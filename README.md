# Week 5 Assignment - Create pretty apps

This is assignment 5 of the 'mobile application development' course at Munich University of Applied Sciences.

## Basics for this assignment
Follow lesson 10 'Designing for Everyone' in the [udacity course](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012)
or read [10.1 and 10.2, and if you like 10.3](https://codelabs.developers.google.com/android-kotlin-fundamentals/) in Google codelabs.

## What to do with this repository

1. Clone the repository
2. Create a development branch. Work on the development branch. When you are done with the assignment, then create a Pull request to merge your finished work back on the master branch. 
3. Read the assignment on [Moodle Assignment 'Week 5 - Lesson 10 of online course'](https://moodle.hm.edu/mod/assign/view.php?id=442853) or continue reading down below.
4. Start coding and have fun.

## Assignment

This assignment is about themes, styles, and attributes. The goal is to make the app in the repository as professional-looking as you can. Please use [Material Design](https://material.io/).

The starter code is an app called **NASA_Apod**. Apod stands for [Astronomy Picture of the Day](https://apod.nasa.gov/apod/astropix.html). This is a collection of images provided by NASA with an [api](https://data.nasa.gov/Space-Science/Astronomy-Picture-of-the-Day-API/ez2w-t8ua) to retrieve the Astronomy Picture of the Day as well as archived pictures for previous days. The api can be accessed with just the key 'DEMO_KEY'. No personal api key is required.

Screenshot of the starter code in the repository (left) and an example of how to make the app better looking (right):

starter code: <img height="500" src="https://github.com/gsocher/w5/blob/master/doc/starter_app.png">        potential solution: <img height="500" src="https://github.com/gsocher/w5/blob/master/doc/styled_app_example.png">

For this assignment:

- Use a material design theme, e.g. ```Theme.MaterialComponents```
- Use a layout suitable for images, e.g. a ```GridLayout```.
- Use a color scheme that matches the astronomy theme of the app.
- Make sure the app looks great for portrait and landscape orientation.
- Use a good label on the toolbar (Apod is kind of hard to understand).
- Be creative. Make the app pretty. Use your own ideas. The app doesn't have to look like the picture on the right.




## Continuous Deployment to Github Releases with Travis-CI

We have used [Travis-ci](https://travis-ci.com/) for your builds. Travis-ci is a continuous integration server. The ```.travis.yml``` file in your repo configures Travis-ci. We want to use continuous deployment of the apk that Travis-ci builds back to Github. The ```.travis.yml``` has a deploy script. You need to add an environment variable to your repository settings in Travis-ci.
- Tag your build once you are done with the assignment: ```git tag v1.0``` and ```git push origin v1.0```. You can use v1.0 as your tagname or another tagname.
- You need a Github token to allow Travis-ci to push to your repository. You can use last week's token. If you can not remember this token, go to [https://github.com/settings/tokens/new](https://github.com/settings/tokens/new) to create a second personal access token. Enter ```travis-ci-release-token-2``` in the 'Note' text field and check the 'repo' checkbox. Click 'Generate token'.
- Copy the token you see.
- Go to [https://travis-ci.com/](https://travis-ci.com/) and go to your w5- repository. Click on 'More options -> Settings', scroll to 'Environment Variables'
- Enter a new Environment Variable called GITHUB_API_KEY
<p align="center">
  <img  src="https://miro.medium.com/max/1400/1*YKZ0pQW7EYZQV70qq5WMZw.png">
</p>
- Click on 'More options -> Trigger build'. 
- After the build has finished, check the 'releases' tab in your Github repository. 

To read more about Anroid and Travis-ci go to https://medium.com/android-bits/android-app-from-scratch-part-5-continuous-integration-with-travis-ci-1a6d30d22822.
