package com.cursosandroidant.stores

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosandroidant.stores.databinding.FragmentEditStoreBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EditStoreFragment : Fragment() {

    private lateinit var mBinding: FragmentEditStoreBinding
    private var mActivity:MainActivity? = null
    private var mIsEditmode:Boolean = false
    private var mStoreEntity: StoreEntity? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mBinding = FragmentEditStoreBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getLong(getString(R.string.arg_id), 0)
        if(id != null && id != 0L){
            mIsEditmode = true
            getStore(id)
        }else{
            mIsEditmode = false
            mStoreEntity = StoreEntity(name = "", phone = "", photoUrl = "")
        }

        setupActionBar()

        setupTextFields()
    }

    private fun setupActionBar() {
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = if(mIsEditmode)getString(R.string.edit_store_title_edit)
                                                else getString(R.string.edit_store_title_add)

        setHasOptionsMenu(true)
    }

    private fun setupTextFields() {

        with(mBinding) {
            etPhotoUrl.addTextChangedListener { validateFields(tilPhotoUrl)
                loadImage(it.toString().trim())}
            etPhone.addTextChangedListener { validateFields(tilPhone) }
            etName.addTextChangedListener { validateFields(tilName) }
        }
    }

    private fun loadImage(url:String){

        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(mBinding.imgPhoto)
    }

    private fun getStore(id: Long) {
        doAsync {
            mStoreEntity = StoreApplication.database.storeDao().getStoreById(id)
            uiThread {
                if(mStoreEntity != null) setUiStore(mStoreEntity!!)
            }
        }
    }

    private fun setUiStore(storeEntity: StoreEntity) {
        with(mBinding){
            etName.text = storeEntity.name.editable()
            etPhone.text = storeEntity.phone.editable()
            etWebsite.text = storeEntity.website.editable()
            etPhotoUrl.text = storeEntity.photoUrl.editable()
        }
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                mActivity?.onBackPressed()
                true
            }
            R.id.action_save -> {
                if(mStoreEntity != null &&
                    validateFields(mBinding.tilPhotoUrl, mBinding.tilPhone, mBinding.tilName)){

                    with(mStoreEntity!!){
                        name = mBinding.etName.text.toString().trim()
                        phone = mBinding.etPhone.text.toString().trim()
                        website = mBinding.etWebsite.text.toString().trim()
                        photoUrl = mBinding.etPhotoUrl.text.toString().trim()
                    }

                    doAsync {
                        if(mIsEditmode) StoreApplication.database.storeDao().updateStore(mStoreEntity!!)
                        else mStoreEntity!!.id =  StoreApplication.database.storeDao().addStore(mStoreEntity!!)

                        uiThread {
                            hideKeyboard()

                            if(mIsEditmode){
                                mActivity?.updateStore(mStoreEntity!!)
                                Snackbar.make(mBinding.root,
                                    R.string.edit_store_message_update_success, Snackbar.LENGTH_SHORT).show()
                            }else {
                                mActivity?.addStore(mStoreEntity!!)

                                Toast.makeText(
                                    mActivity,
                                    R.string.edit_store_message_save_success,
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                            mActivity?.onBackPressed()
                        }
                    }
                }
                 true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun validateFields(vararg textFields: TextInputLayout): Boolean{
        var isValid = true

        for(textField in textFields){
            if(textField.editText?.text.toString().trim().isEmpty()){
                textField.error = getString(R.string.helper_required)
                textField.editText?.requestFocus()
                isValid = false
            }else textField.error = null
        }

        if(!isValid) Snackbar.make(mBinding.root, R.string.edit_store_message_valid,
            Snackbar.LENGTH_SHORT).show()

        return isValid
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if(mBinding.etPhotoUrl.text.toString().trim().isEmpty()){
            mBinding.tilPhotoUrl.error = getString(R.string.helper_required)
            isValid = false
            mBinding.etPhotoUrl.requestFocus()
        }

        if(mBinding.etPhone.text.toString().trim().isEmpty()){
            mBinding.tilPhone.error = getString(R.string.helper_required)
            isValid = false
            mBinding.etPhone.requestFocus()
        }

        if(mBinding.etName.text.toString().trim().isEmpty()){
            mBinding.tilName.error = getString(R.string.helper_required)
            isValid = false
            mBinding.etName.requestFocus()
        }

        return isValid
    }

    private fun hideKeyboard(){
        mActivity?.currentFocus?.let { view ->
            val imm = mActivity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun onDestroyView() {
        hideKeyboard()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = getString(R.string.app_name)
        mActivity?.hideFab(true)
        setHasOptionsMenu(false)
        super.onDestroy()
    }

}