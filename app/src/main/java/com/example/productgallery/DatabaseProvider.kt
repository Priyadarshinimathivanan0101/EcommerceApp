package com.example.productgallery

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class DatabaseProvider : ContentProvider() {

    companion object {
        val PROVIDER_NAME = "com.example.productgallery/DatabaseProvider"
        val URL = "content://$PROVIDER_NAME/PRODUCTS"
        var CONTENT_URI = Uri.parse(URL)

        val ID = "PRODUCT_ID"
        val PRODUCT_NAME = "PRODUCT_NAME"
        val PRODUCT_BRAND = "PRODUCT_BRAND"
        val PRODUCT_PRICE = "PRODUCT_PRICE"
        val PRODUCT_QUANTITY = "PRODUCT_QUANTITY"
        val PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION"
        val PRODUCT_DISCOUNT = "PRODUCT_DISCOUNT"
        val PRODUCT_CATEGORY = "CATEGORY"
    }

    lateinit var db: SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper = getContext()?.let { DatabaseHelper(it) }

        if (helper != null) {
            db = helper.writableDatabase
        }
        return if(db == null) false else true
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("PRODUCTS", null, cv)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }

    override fun update(uri: Uri, cv: ContentValues?, condition: String?, conditionValue: Array<out String>?): Int {
        var count = db.update("PRODUCTS", cv, condition, conditionValue)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    override fun delete(uri: Uri, condition: String?, conditionValue: Array<out String>?): Int {
        var count = db.delete("PRODUCTS", condition, conditionValue)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        conditionValue: Array<out String>?,
        order: String?,
    ): Cursor? {
        return db.query("PRODUCTS", cols, condition, conditionValue, null,null, order)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.men_fashion"
    }

}