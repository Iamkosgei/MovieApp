# MovieApp
A movie app using android architecture components using kotlin and Android Jetpack Components.

## Architecture 
MVVM architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component.

![MVVM](https://user-images.githubusercontent.com/14147462/118546931-545ca300-b761-11eb-9400-275023a5cdd2.png)


## SCREENSHOTS
<p float="left">
  <img src="https://user-images.githubusercontent.com/14147462/118546853-34c57a80-b761-11eb-8475-2387a1f49c35.jpg" width="250" />
    <img src="https://user-images.githubusercontent.com/14147462/118546865-398a2e80-b761-11eb-9e93-a9853fb24242.jpg" width="250" />
  <img src="https://user-images.githubusercontent.com/14147462/118546869-3abb5b80-b761-11eb-9e8f-9e7bd21d9bb2.jpg" width="250" />
</p>
<p float="left">
  <img src="https://user-images.githubusercontent.com/14147462/118546871-3b53f200-b761-11eb-9f6d-97c753224ce2.jpg" width="250" />
  <img src="https://user-images.githubusercontent.com/14147462/118546873-3bec8880-b761-11eb-909b-58977f33b460.jpg" width="250" />
    <img src="https://user-images.githubusercontent.com/14147462/118547859-478c7f00-b762-11eb-8eba-b82229abf24b.jpg" width="250" />
</p>


## Prerequisite

Create your account or login to the Movie DB Api. After that go to the settings page to get your Api key.
Once you get the API Key add the API Key to gradle.properties

```
API_KEY="*******"
```

## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Live data](https://kotlinlang.org/) - LiveData is a data holder class that can be observed within a given lifecycle.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
    * [HILT](https://developer.android.com/training/dependency-injection/hilt-android) -Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. 
    * [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android.
    * [Room](https://developer.android.com/topic/libraries/architecture/room) - a persistence library provides an abstraction layer over SQLite.
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - ViewModel is designed to store and manage UI-related data in a lifecycle conscious way. Write perfect code that works consistently across all Android versions and devices.
    * [Navigation component ](https://developer.android.com/guide/navigation/navigation-getting-started) - Navigation component is the API and the design tool in Android Studio that makes it much easier to create and edit navigation flows.
    * [Timber](https://github.com/JakeWharton/timber) - a highly extensible android logger.
    * [Leak Canary](https://github.com/square/leakcanary) - a memory leak detection library for Android.
    * [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
    * [Shimmer for Android](https://facebook.github.io/shimmer-android/) - Shimmer is an Android library that provides an easy way to add a shimmer effect to any view in your Android app.