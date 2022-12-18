package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Skill():Parcelable {
    @SerializedName("status")
    @Expose
    private var status: Int? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("SkillList")
    @Expose
    private var skillList: List<Skill>? = null

    constructor(parcel: Parcel) : this() {
        status = parcel.readValue(Int::class.java.classLoader) as? Int
        message = parcel.readString()
        skillList = parcel.createTypedArrayList(CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(status)
        parcel.writeString(message)
        parcel.writeTypedList(skillList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Skill> {
        override fun createFromParcel(parcel: Parcel): Skill {
            return Skill(parcel)
        }

        override fun newArray(size: Int): Array<Skill?> {
            return arrayOfNulls(size)
        }
    }
}