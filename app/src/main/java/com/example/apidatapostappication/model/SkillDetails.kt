package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName




class SkillDetails():Parcelable {

    @SerializedName("SKillID")
    @Expose
    var sKillID: Int? = null

    @SerializedName("SkillName")
    @Expose
    var skillName: String? = null

    @SerializedName("IsActive")
    @Expose
    var isActive: Int? = null

    constructor(parcel: Parcel) : this() {
        sKillID = parcel.readValue(Int::class.java.classLoader) as? Int
        skillName = parcel.readString()
        isActive = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(sKillID)
        parcel.writeString(skillName)
        parcel.writeValue(isActive)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkillDetails> {
        override fun createFromParcel(parcel: Parcel): SkillDetails {
            return SkillDetails(parcel)
        }

        override fun newArray(size: Int): Array<SkillDetails?> {
            return arrayOfNulls(size)
        }
    }
}