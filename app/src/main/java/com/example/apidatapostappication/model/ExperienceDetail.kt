package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class ExperienceDetail ():Parcelable{
    @SerializedName("CandidateExperienceID")
    @Expose
    private var candidateExperienceID: Int? = null

    @SerializedName("CandidateID")
    @Expose
    private var candidateID: Int? = null

    @SerializedName("CompanyName")
    @Expose
    private var companyName: String? = null

    @SerializedName("StartDate")
    @Expose
    private var startDate: String? = null

    @SerializedName("EndDate")
    @Expose
    private var endDate: String? = null

    @SerializedName("Designation")
    @Expose
    private var designation: String? = null

    @SerializedName("ContactPerson")
    @Expose
    private var contactPerson: Any? = null

    @SerializedName("Phone")
    @Expose
    private var phone: Any? = null

    @SerializedName("CTC")
    @Expose
    private var ctc: Any? = null

    @SerializedName("CreatedDate")
    @Expose
    private var createdDate: String? = null

    constructor(parcel: Parcel) : this() {
        candidateExperienceID = parcel.readValue(Int::class.java.classLoader) as? Int
        candidateID = parcel.readValue(Int::class.java.classLoader) as? Int
        companyName = parcel.readString()
        startDate = parcel.readString()
        endDate = parcel.readString()
        designation = parcel.readString()
        createdDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(candidateExperienceID)
        parcel.writeValue(candidateID)
        parcel.writeString(companyName)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(designation)
        parcel.writeString(createdDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExperienceDetail> {
        override fun createFromParcel(parcel: Parcel): ExperienceDetail {
            return ExperienceDetail(parcel)
        }

        override fun newArray(size: Int): Array<ExperienceDetail?> {
            return arrayOfNulls(size)
        }
    }

    fun getCompanyName(): String? {
        return companyName
    }
    fun getExperienceDetails(): List<ExperienceDetail?>? {
       return emptyList()
    }
}