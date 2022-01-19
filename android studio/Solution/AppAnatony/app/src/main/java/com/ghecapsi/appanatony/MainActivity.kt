package com.ghecapsi.appanatony

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }


        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }
    }



    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }



    /**
     * Click listener for the countUp button.
     */
    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        // If text is the default "Hello World!" set that text to 1.
        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            // Otherwise, increment the number up to 6.
            // The text value in resultText.text is an instance of the CharSequence class;
            // it needs to be converted to a String object before it can be converted to an int.
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }





}


/**
 *
 * Challenge: Add a second button to the app labeled "Count Up" that appears just below the Roll button.
 * When tapped, the Count Up button should get the current value of the result text view, add 1 to it,
 * and update the text view. Make sure you handle these edge cases:

If the result text view does not yet contain a number (that is, if the text view still has the default
"Hello World" string), set the result text to 1.
If the number is already 6, do nothing.


                val countButton: Button = findViewById(R.id.countup_button)
                countButton.setOnClickListener { countUp() }
 *
 *
 * **/







/**
 *     In this class, you create a new app project called DiceRoller and add basic interactivity with a button.
 *     Each time the button is clicked, the value of the displayed text changes.
 *     The final DiceRoller app for this class looks like this:
 *
 *                           Step 1: Examine MainActivity
 *
 *         MainActivity is an example of an Activity. An Activity is a core Android class that draws
 *         an Android app user interface (UI) and receives input events. When your app launches,
 *         it launches the activity specified in the AndroidManifest.xml file
 *
 *
 *         Many programming languages define a main method that starts the program. Android apps don't have a main method.
 *         Instead, the AndroidManifest.xml file indicates that MainActivity should be launched
 *         when the user taps the app's launcher icon. To launch an activity, the Android OS uses the information in
 *         the manifest to set up the environment for the app and construct the MainActivity.
 *         Then the MainActivity does some setup in turn.

           Each activity has an associated layout file. The activity and the layout are connected by a process
           known as layout inflation. When the activity starts, the views that are defined in the XML layout files are
           turned into (or "inflated" into) Kotlin view objects in memory. Once this happens, the activity can draw these objects to
           the screen and also dynamically modify them.



            In Android Studio, select File > New > New Project to create a new project.
             Use the Empty activity and click Next.
            Call the project DiceRoller, and verify all the other values for project name project location.
             Make sure "Use AndroidX Artifacts" is checked. Click Finish.


      AppCompatActivity is a subclass of Activity that supports all modern Android features while providing backward
      compatibility with older versions of Android. To make your app available to the largest number of devices and users possible,
     always use AppCompatActivity.


      Notice the onCreate() method. Activities do not use a constructor to initialize the object.
      Instead, a series of predefined methods (called "lifecycle methods") are called as part of the activity setup.
     One of those lifecycle methods is onCreate(), which you always override in your own app.
     You learn more about the lifecycle methods in a later


      In onCreate(), you specify which layout is associated with the activity, and you inflate the layout.
      The setContentView() method does both those things.


    The setContentView() method references the layout using R.layout.activity_main, which is actually an integer reference.
    The R class is generated when you build your app. The R class includes all the app's assets,
    including the contents of the res directory.

    In this case, R.layout.activity_main refers to the generated R class, the layout folder,
    and the activity_main.xml layout file. (Resources do not include file extensions.)
    You'll refer to many of the app's resources (including images, strings, and elements within the layout file)
    using similar references in the R class.


                  Step 2: Examine and explore the app layout file



                    All the activities in your app have an associated layout file in the app's res/layout directory.
                    A layout file is an XML file that expresses what an activity actually looks like.
                    A layout file does this by defining views and defining where the views appear on the screen.

                    Views are things like text, images, and buttons that extend the View class.
                    There are many types of views, including TextView, Button, ImageView, and CheckBox.

                    In this task, you examine and modify the app layout file.

                    In the Project > Android pane, expand res > layout and double-click activity_main.xml.
                    The layout design editor opens. Android Studio includes this editor,
                    which lets you build your app's layout in a visual way and preview the layout design.
                    You learn more about the design editor in a later class.
                    To view the layout file as XML, click the Text tab at the bottom of the window.
 *
 *
 *
 *                               4. Task: Add a button
 *
 *                               The dice-rolling app isn't very useful without a way for the user to roll the dice and see
 *                               what they rolled. To start, add a button to the layout to roll the dice,
 *                               and add text that shows the dice value that the user rolled.

                                    Step 1: Add a button to the layout
                        Add a Button element to the layout below the text view by entering <Button and then press Return.
                        A Button block appears that ends with /> and includes the layout_width and layout_height attributes.

                                            <Button
                                            android:layout_width="wrap_content"
                                            android:layout_height="wrap_content"
                                            android:text="Roll" />
 *
 *
 *
                         * For Button views the text attribute is the label of the button. In the layout editor,
                         * the attribute is highlighted in yellow, which indicates a tip or a warning. In this case,
                         * the yellow highlighting is because the string "Roll" is hardcoded in the button label,
                         * but the string should be a resource. You learn about string resources in the next section.
 *
 *
 *
 *
                 * Step 2: Extract string resources
                Instead of hardcoding strings in your layout or code files, it's a best practice to put all your app strings
                into a separate file. This file is called strings.xml, and it is located among the app's resources,
                in the res/values/ directory.

                Having the strings in a separate file makes it easier to manage them, especially if you use these strings more than once.
                Also, string resources are mandatory for translating and localizing your app, because you need
                to create a string resource file for each language.
                Android Studio helps you remember to put your strings into a resource file with hints and warnings.

                Click once on the "Roll" string in the android:text attribute of the <Button> tag.
                Press Alt+Enter (Option+Enter in macOS) and select Extract string resource from the popup menu.
                Enter roll_label for the Resource name.
                Click OK. A string resource is created in the res/values/string.xml file, and the string in
                the Button element is replaced with a reference to that resource: android:text="@string/roll_label"
                In the Project > Android pane, expand res > values, and then double-click strings.xml
                to see your string resources in the strings.xml file:


                            <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_gravity="center_horizontal"
                            android:textSize="30sp"
                            android:text="Hello World!" />



                            <Button
                            android:id="@+id/roll_button"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_gravity="center_horizontal"
                            android:text="@string/roll_label" />



                Step 4: Get a reference to the button in code
                The Kotlin code in MainActivity is responsible for defining the interactive parts of your app,
                such as what happens when you tap a button. To write a function that executes when the button is clicked,
                you need to get a reference to the Button object in your inflated layout in MainActivity.
                To get a reference to the button:

                Assign the Button an ID in the XML file.
                Use the findViewById() method in your code to get a reference to the View with a specific ID.
                Once you have a reference to the Button view, you can call methods on that view to dynamically change it as the app runs.
                For example, you can add a click handler that executes code when the button is tapped.

                Open the activity_main.xml layout file, if it is not already open, and click the Text tab.
                Add the android:id attribute to the button, and give it a name (in this case, "@+id/roll_button").
                Your <Button> element now looks like this:



            When you create an ID for a view in the XML layout file, Android Studio creates an integer constant with that ID's name in
            the generated R class. So if you name a view roll_button, Android Studio generates and creates an integer
            constant called roll_button in the R class. The "@+id" prefix for the ID name tells the compiler to add
            that ID constant to the R class. All the view IDs in your XML file must have this prefix..




            Step 5: Add a click handler to display a toast
            A click handler is a method that is invoked each time the user clicks or taps on a clickable UI element,
            such as a button. To create a click handler you need:

            A method that performs some operation.
            The setOnClickListener() method, which connects the Button to the handler method.
            In this task, you create a click-handler method to display a Toast.
            (A toast is a message that pops up the screen for a short time.)
           You connect the click-handler method to the Button.

          In your MainActivity class after onCreate(), create a private function called rollDice().
 *
 *
 *
 *
 *                       private fun rollDice() {}
 *
 *                       Add this line to the rollDice() method to display a Toast when rollDice() is called
 *
 *                       Toast.makeText(this, "button clicked",
                         Toast.LENGTH_SHORT).show()


                    To create a toast, call the Toast.makeText() method. This method requires three things:

                    A Context object. The Context object allows you to communicate with and get information
                    about the current state of the Android OS. You need a Context here so that
                    the Toast object can tell the OS to display the toast. Because AppCompatActivity is a subclass of Context,
                    you can just use the keyword this for the context.
                    The message to be shown, here "button clicked".
                    the duration to show the message. The show() method at the end displays the toast.
                    In onCreate(), after the call to findViewById() add this line to assign rollDice()
                    as a click handler to the rollButton object:


                        rollButton.setOnClickListener { rollDice() }


                        class MainActivity : AppCompatActivity() {

                        override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)
                        setContentView(R.layout.activity_main)

                        val rollButton: Button = findViewById(R.id.roll_button)
                        rollButton.setOnClickListener { rollDice() }
                        }

                        private fun rollDice() {
                        Toast.makeText(this, "button clicked",
                        Toast.LENGTH_SHORT).show()
                        }
                        }
 *
 *
 *                                       Step 2: Display a random number
 *
 *      Finally, in this task you add randomness to the button click, to simulate the roll of the dice.
 *      Each time the button is clicked or tapped your code picks a random number from 1 to 6 and updates the TextView.
 *      The task of generating a random number isn't Android-specific, and you use the Random function on the range to do it.

            At the top of the rollDice() method, use the (1..6).random() method to get a random number between 1 and 6:

            val randomInt = (1..6).random()
            Set the text property to the value of the random integer, as a string:

            resultText.text = randomInt.toString()
 *
 *
 *
 * **/

