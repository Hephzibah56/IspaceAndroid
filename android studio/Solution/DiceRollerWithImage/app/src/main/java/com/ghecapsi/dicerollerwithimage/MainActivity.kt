package com.ghecapsi.dicerollerwithimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //create a field to hold the ImageView
    //var diceImage : ImageView? = null

    /**
     * Minimize the calls to findViewById() in your code by declaring
     * fields to hold those views, and initializing the fields in onCreate().
     * Use the lateinit keyword for the field to avoid needing to declare it nullable.
     * **/
    lateinit var diceImage : ImageView

    /**
     * Ideally you would initialize this variable up here when it's declared,
     * or in a constructor—but Android activities don't use constructors.
     * In fact, the views in the layout are not accessible objects in memory
     * at all until after they have been inflated in the onCreate() method,
     * by the call to setContentView(). You can't initialize the diceImage
     * variable at all until that happens.
     *
     *
     *     One option is to define the diceImage variable as nullable,
     *     as in this example. Set it to null when it's declared,
     *     and then assign it to the real ImageView in onCreate() with findViewById().
     *     This will complicate your code, however,
     *     because now you have to check for the null value every time
     *     you want to use diceImage. There's a better way.
     *
     *
     *    3- Change the diceImage declaration to use the lateinit keyword,
     *    and remove the null assignment
     *
     *    lateinit var diceImage : ImageView
     *
     *    The lateinit keyword promises the Kotlin compiler that the variable
     *    will be initialized before the code calls any operations on it.
     *    Therefore we don't need to initialize the variable to null here,
     *    and we can treat it as a non-nullable variable when we use it.
     *    It is a best practice to use lateinit with fields that hold views in just this way.
     *
     * **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)
    }


    /**
     *
     *         tools in xml
     *         Here you've changed the XML namespace of this attribute from the default
     *         android namespace to the tools namespace. The tools namespace is used when
     *         you want to define placeholder content that is only used in the preview or
     *         the design editor in Android Studio. Attributes using the tools namespace
     *         are removed when you compile the app.
     *
     *
     *
     * **/

    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

       // val diceImage: ImageView = findViewById(R.id.dice_image)

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

        /**
         * Add a when block to choose a specific dice image based on the value of randomInteger
         * **/


        /**
         *
         * Everything in your app works, but there's more to developing apps than
         * just having code that works. You should also understand how to write performant,
         * well-behaving apps. This means your apps should run well, even if your user doesn't have
         * the most expensive Android device or the best network connectivity.
         * Your apps should also continue to run smoothly as you add more features,
         * and your code should be readable and well organized.In this task,
         * you learn about one way to make your app more efficient.
         *
         *         app performance
         *
         *        Because rollDice() is the click handler for the Roll button,
         *        every time the user taps that button, your app calls findViewById()
         *        and gets another reference to this ImageView. Ideally, you should minimize
         *        the number of calls to findViewById(), because the Android system is searching
         *        the entire view hierarchy each time, and that's an expensive operation.
         *
         *
         *
         *
         *        In a small app like this one, it's not a huge problem.
         *        If you're running a more complicated app on a slower phone,
         *        continually calling findViewById() could cause your app to lag.
         *        Instead it is a best practice to just call findViewById() once and
         *        store the View object in a field. Keeping the reference to the ImageView
         *        in a field allows the system to access the View directly at any time,
         *         which improves performance.
         *
         *
         * **/


    }



    /**
     * Click listener for the countUp button.
     */


}



/**
 * At the end of the last class, you had an app that updates a text view with
 * a number between 1 and 6 each time the user taps a button. However,
 * the app is called DiceRoller, not 1-6 Number Generator,
 * so it would be nice if the dice actually looked like dice.
 * In this task, you add some dice images to your app.
 * Then instead of updating text when the button is pressed,
 * you swap in a different image for each roll result.
 *
 *
 *
 * Your app uses many different resources including images and icons,
 * colors, strings, and XML layouts. All those resources are stored in the res folder.
 * The drawable folder is where you should put all the image resources for your app.
 * Already in the drawable folder you can find the resources for the app's
 * launcher icons. 3. Double-click ic_launcher_background.xml.
 * Note that these are XML files that describe the icon as a vector image.
 * Vectors enable your images to be drawn at many different sizes and resolutions.
 * Bitmap images such as PNG or GIF may need to be scaled for different devices,
 * which can result in some loss of quality.
 *
 *              Update the layout to use
 *
 *              <ImageView
        android:id="@+id/dice_image"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:src="@drawable/dice_1" />
 *
 *             Update the code
 *
 *       Understand API levels and compatibility
 *
 *       One of the great things about developing for Android is the  number
 *       of devices your code can run on—from the Nexus One to the Pixel,
 *       to form factors like tablets, to Pixelbooks, to watches, TVs, and cars.
 *       When you write for Android, you don't write completely separate apps for each of
 *       these different devices—even apps that run on radically different form factors
 *       such as watches and TVs can share code.
 *       But there are still constraints and compatibility strategies that you need
 *       to be aware of to support all of this.

         In this task, you learn how to target your app for specific Android API levels
         (versions), and how to use the Android Jetpack libraries to support older devices.


                             Explore API levels

In the previous class, when you created your project, you indicated the specific
Android API level that your app should support. The Android OS has different version
numbers named after tasty treats which are in alphabetical order.
Each OS version ships with new features and functionality.
For example, Android Oreo shipped with support for Picture-in-picture apps,
while Android Pie introduced Slices. The API levels correspond to the Android versions.
For example, API 19 corresponds to Android 4.4 (KitKat).
Due to a number of factors, including what the hardware can support,
whether users choose to update their devices, and whether manufacturers support
different OS levels, users inevitably end up with devices that run different OS versions.

When you create your app project, you specify the minimum API level that your app supports.
That is, you specify the oldest Android version your app supports.
Your app also has a level to which it is compiled, and a level that it targets.
Each of these levels is a configuration parameter in your Gradle build files.

Expand the Gradle Scripts folder, and open the build.gradle (Module: app) file.
This file defines build parameters and dependencies specific to the app module.
The build.gradle (Project: DiceRoller) file defines build parameters
for the project as a whole. In many cases, your app module is the only module
in your project, so this division may seem arbitrary. But if your app becomes more
complex and you split it into several parts, or if your app supports platforms like
Android watch, you may encounter different modules in the same project.
2. Examine the android section towards the top of the build.gradle file.
(The sample below is not the entire section, but it contains what
you're most interested in for this class.)


                            android {
                            compileSdkVersion 31
                            defaultConfig {
                            applicationId "com.example.android.diceroller"
                            minSdkVersion 21
                            targetSdkVersion 32
                            versionCode 1
                            versionName "1.0"
                             }
                compileSdkVersion 31
This parameter specifies the Android API level that Gradle should use to compile your app.
This is the newest version of Android your app can support. That is, your app can use
the API features included in this API level and lower. In this case your app supports
API 31

Examine the targetSdkVersion parameter, which is inside the defaultConfig section:

    targetSdkVersion 32
This value is the most recent API that you have tested your app against.
In many cases this is the same value as compileSdkVersion.

       minSdkVersion 21

This parameter is the most important of the three, as it determines the oldest version of Android on which your app will run. Devices that run the Android OS older than this API level cannot run your app at all.

Choosing the minimum API level for your app can be challenging. Set the API level too low, and you miss out on newer features of the Android OS. Set it too high, and your app may only run on newer devices.

When you set up your project and you come to the place where you define the minimum
API level for your app, click Help me choose to see the API Version Distribution dialog.
The dialog gives information about how many devices use different OS levels,
and features that were added or changed in the OS levels.
You can also check out the Android documentation release notes and dashboard,
which have further information about the implications of supporting different API levels.


              Step 2: Explore compatibility


Writing for different Android API levels is a common challenge that app developers face,
so the Android framework team has done a lot of work to help you out.

In 2011, the team released the first support library, a Google-developed library
that offers backward-compatible classes and helpful functions. In 2018,
Google announced Android Jetpack, which is a collection of libraries that
includes many of the previous classes and functions of the support library,
while also expanding on the support library.


AppCompatActivity is a compatibility class that ensures your activity
looks the same across different platforms OS levels.


          Add compatibility for vector drawables

Expand the res folder and then expand drawable. Double click one of the dice images.
As you learned earlier, all the dice images are actually XML files that define
the colors and shapes for the dice. These kinds of files are called vector drawables.
The nice thing about vector drawables versus bitmap image formats like PNG is that
vector drawables can scale without losing quality. Also, a vector drawable is usually
a much smaller file than the same image in a bitmap format.

An important thing to note about vector drawables is that they are supported
in API 21 onwards. But your app's minimum SDK is set to API 21.
If you tried your app on an API 19 device or emulator,
you'd see that the app seems to build and run just fine. So how does this work?

vectorDrawables.useSupportLibrary = true



When you build your app, the Gradle build process generates a PNG file
from each of the vector files, and those PNG files are used on any Android device below 21.
These extra PNG files increase the size of your app.
Unnecessarily large apps aren't great—they make downloads slower
for users and take up more of their devices' limited space.
Large apps also have a higher chance of being uninstalled,
and of users failing to download or canceling downloads of those apps.

The good news is that there is an Android X compatibility library for vector
drawables all the way back to API level 7. 2. Open build.gradle (Module: app).
Add this line to the defaultConfig section:



     code challenge
Challenge: Modify the DiceRoller app to have two dice.
When the user taps the Roll button, each dice should have a value independent of the other.
Tip: Create a new private function to get a random drawable image and return
an integer for the drawable resource. Use that function for each of the dice images.



 *
 * **/