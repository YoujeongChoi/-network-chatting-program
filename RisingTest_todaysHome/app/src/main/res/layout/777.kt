<androidx.constraintlayout.widget.ConstraintLayout
android:id="@+id/home_top_bar"
android:layout_width="match_parent"
android:layout_height="wrap_content"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintStart_toStartOf="parent">

<ImageButton
android:layout_width="25dp"
android:layout_height="25dp"
android:src="@drawable/menu_dark_2"
android:background="@android:color/transparent"
android:scaleType="fitCenter"
android:layout_marginStart="15dp"
android:layout_marginTop="10dp"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent"/>

<ImageButton
android:layout_width="25dp"
android:layout_height="25dp"
android:src="@drawable/settings_dark"
android:background="@android:color/transparent"
android:scaleType="fitCenter"
android:layout_marginEnd="15dp"
android:layout_marginTop="10dp"

app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintTop_toTopOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>

<TextView
android:id="@+id/home_location"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="성북구 정릉로"
android:textSize="32dp"
app:layout_constraintTop_toBottomOf="@id/home_top_bar"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent"
android:textColor="#696969"
android:textStyle="bold"
android:layout_marginTop="60dp"/>

<TextView
android:id="@+id/home_status"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="매우 좋음"
android:textSize="28sp"
app:layout_constraintTop_toBottomOf="@id/home_location"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent"
android:textColor="#696969"
android:textStyle="bold"
android:layout_marginTop="30dp"/>

<ImageView
android:id="@+id/home_face_icon"
android:layout_width="80dp"
android:layout_height="80dp"
android:src="@drawable/face_very_good"
android:background="@android:color/transparent"
app:layout_constraintStart_toStartOf="@id/home_status"
app:layout_constraintTop_toBottomOf="@id/home_status"
app:layout_constraintEnd_toEndOf="@id/home_status"
android:layout_marginTop="50dp"/>

<TextView
android:id="@+id/home_air_quality"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="대기환경지수: 23"
android:textSize="28sp"
app:layout_constraintTop_toBottomOf="@id/home_face_icon"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent"
android:textColor="#696969"
android:textStyle="bold"
android:layout_marginTop="60dp"/>

<TextView
android:id="@+id/home_fine_dust"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="초미세먼지: 9㎍/㎥"
android:textSize="28sp"
app:layout_constraintTop_toBottomOf="@+id/home_air_quality"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent"
android:textColor="#696969"
android:textStyle="bold"
android:layout_marginTop="30dp"/>
