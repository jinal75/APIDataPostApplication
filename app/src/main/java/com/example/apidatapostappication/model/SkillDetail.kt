package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class SkillDetail():Parcelable {
    @SerializedName("CandidateSkillJoinID")
    @Expose
    private var candidateSkillJoinID: Int? = null

    @SerializedName("CandidateID")
    @Expose
    private var candidateID: Int? = null

    @SerializedName("SkillID")
    @Expose
    private var skillID: Int? = null

    @SerializedName("CreatedDate")
    @Expose
    private var createdDate: String? = null

    @SerializedName("ModifiedDate")
    @Expose
    private var modifiedDate: String? = null

    @SerializedName("CreatedBy")
    @Expose
    private var createdBy: Int? = null

    @SerializedName("SkillName")
    @Expose
    private var skillName: String? = null

    constructor(parcel: Parcel) : this() {
        candidateSkillJoinID = parcel.readValue(Int::class.java.classLoader) as? Int
        candidateID = parcel.readValue(Int::class.java.classLoader) as? Int
        skillID = parcel.readValue(Int::class.java.classLoader) as? Int
        createdDate = parcel.readString()
        modifiedDate = parcel.readString()
        createdBy = parcel.readValue(Int::class.java.classLoader) as? Int
        skillName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(candidateSkillJoinID)
        parcel.writeValue(candidateID)
        parcel.writeValue(skillID)
        parcel.writeString(createdDate)
        parcel.writeString(modifiedDate)
        parcel.writeValue(createdBy)
        parcel.writeString(skillName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkillDetail> {
        override fun createFromParcel(parcel: Parcel): SkillDetail {
            return SkillDetail(parcel)
        }

        override fun newArray(size: Int): Array<SkillDetail?> {
            return arrayOfNulls(size)
        }
    }

    fun getSkillName(): String? {
        return skillName
    }
}