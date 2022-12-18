package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DegreeList ():Parcelable{
    @SerializedName("DegreeID")
    @Expose
    var degreeID: String? = null

    @SerializedName("DegreeName")
    @Expose
    var degreeName = null

    @SerializedName("IsActive")
    @Expose
   var isActive: String? = null

    constructor(parcel: Parcel) : this() {
        degreeID = parcel.readString()
        isActive = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(degreeID)
        parcel.writeString(isActive)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DegreeList> {
        override fun createFromParcel(parcel: Parcel): DegreeList {
            return DegreeList(parcel)
        }

        override fun newArray(size: Int): Array<DegreeList?> {
            return arrayOfNulls(size)
        }
    }

}