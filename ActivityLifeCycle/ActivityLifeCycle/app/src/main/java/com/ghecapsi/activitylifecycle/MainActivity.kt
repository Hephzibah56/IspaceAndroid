package com.ghecapsi.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {
    /**
     * How to Implement the Android LifeCycle Callback Methods
     * **/

    private val TAG: String? = "MainActivity"
    private val ZIBAH: String? = "Zeebarh"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate MainActivity");

        /**
         *
         * In this step, your activity is not yet visible.
         * It remains in this state until the onCreate() function finishes,
         * then it quickly moves to the next state.

                  onStart()
        When an application is started, the system will invoke an onStart() method.
        This callback is invoked to make the activity visible to the user.

        Here is how onStart() is implemented.
         *
         *
         * **/


    }


    override fun onStart() {
        Toast.makeText(this, "onStart MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart MainActivity");

        super.onStart()
    }

/**
 * onStart() can be called several times during an application’s lifecycle.
 * For example, this method can be called when a user opens another
 * activity and then navigates back to the previous activity.

During the activity’s lifecycle, the onStop() function is called.
This means that some resources are released. The onStart() method
can be invoked to initialize such resources.

onResume()
Once onStart() is called, onResume() is immediately invoked.
Every component associated with this activity is brought to the foreground state.
The activity is now considered interactive.


 *
 * **/

override fun onResume() {
    Toast.makeText(this, "onResume MainActivity", Toast.LENGTH_SHORT).show()
    Log.d(TAG, "onResume MainActivity")  // creating a custom tag
    Log.i("zibah", "onResumed is called with info tag")
    Log.e("zibah", "onResumed is called with error tag")
    Log.d(ZIBAH, "Error tag called in onResume")
    super.onResume()
}

    /**
     * At this point, the activity remains in the foreground state unless
     * something happens to the application. This may include overly
     * (multi-window mode application) interaction from other applications
     * such as a phone call or when a user navigates to another activity.

         onPause()
    onPause() is called when the user switches to another activity or
    a multi-window mode application. At this point, the activity has
    lost focus and is running in the background.

    This callback will pause the activity and release some
    resources that this activity was consuming. All un-required operations are paused.
     *
     * **/

    override fun onBackPressed(){
        Toast.makeText(this, "Thank you for using our app. Please leave a review",
        Toast.LENGTH_LONG).show()
        super.onBackPressed()

        Toast.makeText(this, "Message", Toast.LENGTH_LONG).show()
        super.onBackPressed()  //when you want to go back
    }
    override fun onPause() {
        Toast.makeText(this, "onPause MainActivity", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onPause MainActivity")
        Log.i("zibah", "onResumed is called with info tag")
        Log.e("zibah", "onResumed is called with error tag")
        Log.d(ZIBAH, "Error tag called in onPause")
        super.onPause()

    }


    /**
     *
     * When onPause() is called, you might release some resources from memory.
     * However, make sure that you initialize them again during the onResume() callback.

    onPause() is a brief callback that allows transition to other activities.
    So, intensive computations should not be executed during this stage. This may delay the application from transitioning to other activities thus leading to a poor user experience.

    onStop()
    At this point, most of the activity processes have been stopped.
    However, the activity is still running in the background.

    This life-cycle usually occurs after the onPause()
    method is executed due to the user switching to other activities
    or pressing the home button.

    In such situations, it is used to release heavy resources
    and stop intensive operations that are not required while the activity is invisible.

    Since onPause() is brief, onStop() can be used to save
    data to other channels such as databases.
     *
     *
     * **/

    override fun onStop() {
        Toast.makeText(this, "onStop MainActivity", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onStop MainActivity")
        Log.i("zibah", "onResumed is called with info tag")
        Log.e("zibah", "onResumed is called with error tag")
        Log.d(ZIBAH, "Error tag called in onStop")
        super.onStop()
    }

    /**
     * Note: At this time, this activity is not destroyed yet.
     * The activity instances are saved in a back stack.
     * This means all stated are still active, including the views.

    When a user opens it again, the application will not reload all instances.
    Instead, it will retrieve them from memory.
    This includes UI components such as the TextViews.

    onRestart()
    Since the activity’s states still exist, the onRestart()
    method can be called when the user restarts the activity.
    This means the activity will go back to the main screen and
    the user can resume interacting with its components.

    As discussed, the onCreate() function is only called once in
    an activity’s life-cycle. So, when the onRestart() method is executed,
    the activity will resume by executing the onStart() then onResume().

     *
     * **/

    override fun onRestart() {
        Toast.makeText(this, "onRestart MainActivity", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onRestart MainActivity")
        Log.i("zibah", "onResumed is called with info tag")
        Log.e("zibah", "onResumed is called with error tag")
        Log.d(ZIBAH, "Error tag called in onRestart")
        super.onRestart()
    }

    /**
     * onDestroy()
    This is the final callback that the activity will receive when it is stopped.

    The method is called when there is a change in the configuration
    states such as screen rotation or language settings.
    The Android system will destroy the activity,
    then recreate it with the set configurations.

     *
     * **/

    override fun onDestroy() {
        Toast.makeText(this, "onDestroy MainActivity", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onDestroy MainActivity")
        super.onDestroy()
    }


    /**
     *
     * To test the app, we will add another activity
     * so that we can read these methods as they change from point A to B.

    In Android Studio, create another empty activity and call it Activity2.
    java We will add the same code as in the MainActivity.java file.
    However, we will change the Toast and Log messages, as shown below:
     * **/

    open fun gotoActivity2(view: View?) {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
}



/**
 *The Android lifecycle helps developers understand which states activities go through
 * when a user navigates through an app. As a result, we can do proper operations at
 * the right time and avoid crashes and other bugs.

An Android application has a lifecycle. It crosses through various stages
from when a user opens and exits an application.

An application’s state helps you manage when a user opens
an activity, pauses, resumes, stops, and destroys it.

Callback methods manage these states.
You can override these methods to do a particular
operation to give the right output to users.

Let’s say your application is running in the background,
and you wish to save some data. In this case,
you have to know about the activity lifecycle.
This allows you to implement the right callback to handle the situation.

Goal
In this tutorial, we will explain different Android
application lifecycle callback states. We will discuss all
the states that apply in an android activity lifecycle.

We will develop an Android app that showcases where
various activity lifecycle callbacks take place.
This application will be life-cycle aware to understand which callback is being executed.

Prerequisites
To follow along, you should have:

Android Studio installed.
A good understanding of Android application development.
Prior knowledge on how to run and use Android Studio Logcat.
Different activity life-cycle callbacks
Let’s now dive in and discuss different
Android application life-cycles and see how we can implement them.

First, ensure that Android Studio is running on your computer.

Then create a new project using the empty activity template.
In this tutorial, we will use Java to build an Android application.
Therefore, ensure that you select Java as your preferred programming language.


An Android activity goes through six major lifecycle stages or callbacks.
These are: onCreate(), onStart(), onResume(), onPause(), onStop(), and onDestroy().
The system invokes each of these callbacks as an activity enters a new state.

Note that it’s not necessary to implement all these lifecycle callbacks in
your Android application. As a developer, you should know when to implement each of
these callbacks depending on the activity’s complexity.




Let’s discuss this activity’s lifecycle and implement them in an actual
Android application.

                         onCreate()
The onCreate() callback is compulsory in all Android applications.
It is the first method called when we launch an activity from the home screen or intent.
In other words, it is a default callback that is automatically created when you create
a new activity.

It’s the only method that developers need to implement activity logic
that should only happen once, such as initializing a ViewModel.

Android Studio automatically creates a class named the MainActivity.java file.
This class contains an onCreate() callback.
It is called when a user first opens the application.



When an application is installed on a device, it is in a doesn't exist state.
This means the activity is dead.

Once a user opens the application,
the lifecycle begins. The activity is brought to the foreground.
In this case, onCreate() is immediately called to fire up the application.
It may contain components such as the activity UI.

Here is a sample code that shows how an onCreate() method is implemented.
I have added a Log and a Toast that we will use to read the activity’s
states later in this guide.

In your MainActivity.java, make sure your onCreate()
method has the lines below to print a Toast and Log message.

Here is a simplified diagram that illustrates how users interact
with an activity lifecycle.
 * **/