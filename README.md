# WinDriverAppSamples

This repository contains examples of test automation for Windows desktop applications.

To run the samples you need java jdk installed (tested with version 1.8.0).

Also Microsoft's WinAppDriver has to be installed.

This can be found here: 

https://github.com/microsoft/WinAppDriver/releases/tag/v1.1

The driver used at the moment of writing this readme was v1.1, not sure how it will work with more modern versions.

To check the automation ids of desktop applications the appium desktop app can be used.
It can be found here

https://github.com/appium/appium-desktop/releases/tag/v1.15.1

To run the samples:

1.- Open the sample in Intellij.

2.- Build the project.

3.- Start the WinAppDriver (it will open a cmd showing that a server is listening).

4.- If needed to inspect the windows app, open appium desktop app and connect using new session, custom server.
    Using the url of WinAppDriver, matching the path ('/' instead of '/wd/hub').

The json of capabilities will be needed at this point.

In the calculator example this json is:

```
{
  "platformName": "windows",
  "deviceName": "WindowsPC",
  "app": "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"
}
```
5.- Run the tests
