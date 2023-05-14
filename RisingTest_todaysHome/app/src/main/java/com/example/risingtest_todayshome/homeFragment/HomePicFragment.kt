package com.example.risingtest_todayshome.homeFragment

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest_todayshome.BannerViewPagerAdapter
import com.example.risingtest_todayshome.HomePic.*
import com.example.risingtest_todayshome.R
import com.google.android.gms.common.api.Result
import kotlinx.android.synthetic.main.fragment_home_hot.*
import kotlinx.android.synthetic.main.fragment_home_pic.*
import kotlinx.android.synthetic.main.home_picture_list_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.System.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomePicFragment : Fragment() {

    private var home_pic_list_array = ArrayList<HomePicture>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getHomePicData()
        val layoutManager = GridLayoutManager(context,1)
        home_pic_rv.layoutManager = layoutManager


        val drawable: GradientDrawable = context?.getDrawable(R.drawable.home_picture_frame) as GradientDrawable
        home_picture_iv.background = drawable
        home_picture_iv.clipToOutline = true
        Log.d(TAG, "우왕2 picture - onCreate() called")

        Log.d(TAG, "우왕 result ${home_pic_list_array.size} - onCreate() called")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_pic, container, false)
    }

    private fun getHomePicData() {
        val weatherDataInterface =
        HomePicRetrofitClient.sRetrofit.create(HomePicRetrofitInterface::class.java)
        weatherDataInterface.getHomePicList()
            .enqueue(object :
                Callback<HomePicResponse> {
                override fun onResponse(
                    call: Call<HomePicResponse>,
                    response: Response<HomePicResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d(TAG, "통신성공 - HomePicFragment - onResponse() called")
                        val results = response.body() as HomePicResponse

                        for (i in 0 until results.result.size) {
                            var varTitle = results.result[i].title
                            var varUrl = results.result[i].imgUrl

                            var varPicList = HomePicture(
                                 varUrl, varTitle
                            )
                            home_pic_list_array.add(varPicList)
                        }
                        val adapter = HomePicAdapter(home_pic_list_array)
                        home_pic_rv.layoutManager = GridLayoutManager(activity, 2)
                        home_pic_rv.adapter = adapter
                        adapter.notifyDataSetChanged()

                    } else {
                        Log.d(ContentValues.TAG, " 이미지 통신실패 - onResponse() called")
                    }

                }

                override fun onFailure(call: Call<HomePicResponse>, t: Throwable) {
                    Log.d(TAG, "통신실패 - onFailure() called")
                }

            })
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

