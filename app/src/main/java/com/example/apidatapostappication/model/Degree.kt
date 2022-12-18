package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Degree ():Parcelable{

    @SerializedName("DegreeID")
    @Expose
    private var degreeID: Int? = null

    @SerializedName("DegreeName")
    @Expose
    private var degreeName: String? = null

    constructor(parcel: Parcel) : this() {
        degreeID = parcel.readValue(Int::class.java.classLoader) as? Int
        degreeName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(degreeID)
        parcel.writeString(degreeName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Degree> {
        override fun createFromParcel(parcel: Parcel): Degree {
            return Degree(parcel)
        }

        override fun newArray(size: Int): Array<Degree?> {
            return arrayOfNulls(size)
        }
    }

    fun getDegreeName(): String? {
        return degreeName
    }


}