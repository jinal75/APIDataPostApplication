package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class DegreeDetails():Parcelable{
    @SerializedName("DegreeID")
    @Expose
    var degreeID: Int? = null

    @SerializedName("DegreeName")
    @Expose
    var degreeName: String? = null

    @SerializedName("IsActive")
    @Expose
    var isActive: Int? = null

    constructor(parcel: Parcel) : this() {
        degreeID = parcel.readValue(Int::class.java.classLoader) as? Int
        degreeName = parcel.readString()
        isActive = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(degreeID)
        parcel.writeString(degreeName)
        parcel.writeValue(isActive)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DegreeDetails> {
        override fun createFromParcel(parcel: Parcel): DegreeDetails {
            return DegreeDetails(parcel)
        }

        override fun newArray(size: Int): Array<DegreeDetails?> {
            return arrayOfNulls(size)
        }
    }

}

