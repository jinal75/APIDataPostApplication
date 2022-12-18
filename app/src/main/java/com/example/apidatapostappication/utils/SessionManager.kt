package com.example.apidatapostappication.utils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.apidatapostappication.MainActivity
import com.example.apidatapostappication.activities.DashBoardActivity
import com.example.apidatapostappication.activities.SignInActivity
import com.example.apidatapostappication.model.Degree
import com.example.apidatapostappication.model.ExperienceDetail
import com.example.apidatapostappication.model.SkillDetail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken




class SessionManager(private val context: Context) {
    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val PRIVATE_MODE = 0


    fun createLoginSessionCandidate(userId:String, userType: String, firstName: String, lastName: String, email: String, profileImg: String, resumeName: String, resumePdf: String, resumeLink: String, languageId: String, notificationtoken: String ) {


        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_UID, userId)
        editor.putString(KEY_USER_TYPE, userType)
        editor.putString(KEY_FIRSTNAME, firstName)
        editor.putString(KEY_LASTNAME, lastName)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PROFILE_IMAGE, profileImg)
        editor.putString(KEY_RESUME_PDF, resumePdf)
        editor.putString(KEY_RESUME_LINK, resumeLink)
        editor.putString(KEY_RESUME_NAME, resumeName)
        editor.putString(KEY_LANGUAGE_ID, languageId)
        editor.putString(KEY_NOTIF_TOKEN, notificationtoken)


        editor.commit()
    }
    @JvmName("setDegreeDetail1")
    fun setDegreeDetail(degreeDetail: List<Degree?>?) {
        val gson = Gson()
        val json = gson.toJson(degreeDetail)
        editor.putString(KEY_DEGREE_LIST, json)
        editor.commit()
    }
    @JvmName("setSkillsDetail1")
    fun setSkillsDetail(skillDetails: List<SkillDetail?>?) {
        val gson = Gson()
        val json = gson.toJson(skillDetails)
        editor.putString(KEY_SKILL_LIST, json)
        editor.commit()
    }


    @JvmName("getDegreeDetail1")
     fun getDegreeDetail(): List<Degree>? {
        val gson = Gson()
        val json =
            pref.getString(KEY_DEGREE_LIST, "")
        val type =
            object : TypeToken<List<Degree?>?>() {}.type
        return gson.fromJson(json, type)
    }


    @JvmName("getSkillsDetail1")
    fun getSkillsDetail(): List<SkillDetail> {
        val gson = Gson()
        val json =
            pref.getString(KEY_SKILL_LIST, "")
        val type =
            object : TypeToken<List<SkillDetail?>?>() {}.type
        return gson.fromJson(json, type)
    }
    @JvmName("setExperienceDetail1")
    fun setExperienceDetail(experienceDetails: List<ExperienceDetail?>?) {
        val gson = Gson()
        val json = gson.toJson(experienceDetails)
        editor.putString(KEY_EXPERIENCE_LIST, json)
        editor.commit()
    }

    @JvmName("getExperienceDetail1")
    fun getExperienceDetail(): List<ExperienceDetail>? {
        val gson = Gson()
        val json =
            pref.getString(KEY_EXPERIENCE_LIST, "")
        val type =
            object : TypeToken<List<ExperienceDetail?>?>() {}.type
        return gson.fromJson(json, type)
    }


    var degreeDetail: List<Degree?>?
        get() {
            val gson = Gson()
            val json =
                pref.getString(KEY_DEGREE_LIST,
                    "")
            val type =
                object : TypeToken<List<Degree?>?>() {}.type
            return gson.fromJson<List<Degree>>(json, type)
        }
        set(degreeDetail) {
            val gson = Gson()
            val json = gson.toJson(degreeDetail)
            editor.putString(KEY_DEGREE_LIST,
                json)
            editor.commit()
        }
    var skillsDetail: List<SkillDetail>?
        get() {
            val gson = Gson()
            val json =
                pref.getString(KEY_SKILL_LIST,
                    "")
            val type =
                object : TypeToken<List<SkillDetail?>?>() {}.type
            return gson.fromJson<List<SkillDetail>>(json, type)
        }
        set(skillDetails) {
            val gson = Gson()
            val json = gson.toJson(skillDetails)
            editor.putString(KEY_SKILL_LIST,
                json)
            editor.commit()
        }
    var experienceDetail: List<Any?>?
        get() {
            val gson = Gson()
            val json =
                pref.getString(KEY_EXPERIENCE_LIST,
                    "")
            val type =
                object : TypeToken<List<ExperienceDetail?>?>() {}.type
            return gson.fromJson<List<ExperienceDetail>>(json, type)
        }
        set(experienceDetails) {
            val gson = Gson()
            val json = gson.toJson(experienceDetails)
            editor.putString(KEY_EXPERIENCE_LIST,
                json)
            editor.commit()
        }


    val candidateDetails: HashMap<String, String?>
        get() {
            val candidate = HashMap<String, String?>()
            candidate[KEY_UID] =
                pref.getString(KEY_UID, null)
            candidate[KEY_USER_TYPE] =
                pref.getString(KEY_USER_TYPE,
                    null)
            candidate[KEY_FIRSTNAME] =
                pref.getString(KEY_FIRSTNAME,
                    null)
            candidate[KEY_LASTNAME] =
                pref.getString(KEY_LASTNAME,
                    null)
            candidate[KEY_EMAIL] =
                pref.getString(Companion.KEY_EMAIL, null)
            candidate[KEY_PROFILE_IMAGE] =
                pref.getString(KEY_PROFILE_IMAGE,
                    null)
            candidate[KEY_RESUME_PDF] =
                pref.getString(KEY_RESUME_PDF,
                    null)
            candidate[KEY_RESUME_LINK] =
                pref.getString(KEY_RESUME_LINK,
                    null)
            candidate[KEY_RESUME_NAME] =
                pref.getString(KEY_RESUME_NAME,
                    null)
            candidate[KEY_LANGUAGE_ID] =
                pref.getString(KEY_LANGUAGE_ID,
                    "en")
            candidate[KEY_NOTIF_TOKEN] =
                pref.getString(KEY_NOTIF_TOKEN,
                    null)

            // return user
            return candidate
        }

    fun checkLogin() {
        if (isLoggedIn) {
            val i = Intent(context, SignInActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        } else {
            val i = Intent(context, SignInActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    fun logoutUser() {
        editor.clear()
        editor.commit()
        val i = Intent(context, SignInActivity::class.java)
        // Closing all the Activities
        i.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(i)
    }



    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN,
            false)

    companion object {
        private const val PREF_NAME = "RetrofitDemoPref"
        private const val IS_LOGIN = "IsLoggedIn"

        //Comman
        const val KEY_UID = "userId"
        const val KEY_USER_TYPE = "userType"
        const val KEY_FIRSTNAME = "firstName"
        const val KEY_LASTNAME = "lastName"
        const val KEY_EMAIL = "email"
        const val KEY_PROFILE_IMAGE = "profileImage"
        const val KEY_LANGUAGE_ID = "languageId"
        const val KEY_NOTIF_TOKEN = "notifToken"

        //Candidate
        const val KEY_RESUME_NAME = "resumeName"
        const val KEY_RESUME_PDF = "resumeFile"
        const val KEY_RESUME_LINK = "resumeLink"
        const val KEY_SKILL_LIST = "skills"
        const val KEY_EXPERIENCE_LIST = "experiences"
        const val KEY_DEGREE_LIST = "degree"
    }

    // Constructor
    init {
        pref =
            context.getSharedPreferences(PREF_NAME,
                PRIVATE_MODE)
        editor = pref.edit()
    }
}