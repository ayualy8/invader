# invader

## ꒰(꜆꜄•ω•)꜆꜄꜆ ᵃʳⁱᵍᵅᵗᵒ for visiting my repository!

Invader game built through [Gradle Built Tool]( https://gradle.org)💓

### Gradle Built Tool;
[![gradlelogo](https://user-images.githubusercontent.com/52661787/70033298-42d21a80-1603-11ea-885d-b218f0829aff.png)](https://gradle.org)



***

The collision detection algorithm I implemented might be a bit off( ´•௰•`) 

Although, here is a possible alternative; Assume the following variables (r1, r2) have the properties: x, y, width, height.

```java
check_collection(r1, r2):
    if ( r1.x < (r2.x + r2.width) ) and
       ( (r1.x + r1.width) > r2.x ) and
       ( r1.y < (r2.y + r2.height) ) and
       ( (r1.height + r1.y) > r2.y ):
       //Collision has been detected
      return true;
    else:
      return false
```

also, the tutors' suggested version of the alternative algorithm for animation; assume each entity will contain a __list__ of sprites that can be swapped to.

```java
AnimationData {
  sprites[];
  currentSpriteIndex;
  delay;
  tick() {
    //Action to take on a draw call
    //use information to delay a sprite transition
    //Loop around if index >= length of sprites
  } 
}
```

###### ଘ(੭ˊ꒳​ˋ)੭✧ this code was written for the assignment 2 of a course at the University of Sydney.

