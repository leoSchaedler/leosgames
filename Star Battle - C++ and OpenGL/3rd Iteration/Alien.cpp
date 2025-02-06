#include "Alien.hpp"
#include "ofMain.h"

Alien::Alien() :
    AbstractGameObject("image/destroyer.png")
{
}

void Alien::hit(const GameObject& other) {
    kill();
}
