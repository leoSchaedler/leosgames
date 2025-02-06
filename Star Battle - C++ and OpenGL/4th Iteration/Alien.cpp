#include "Alien.hpp"
#include "ofMain.h"

Alien::Alien() :
    AbstractGameObject("image/destroyer.png"), isTarget(false)
{
}

void Alien::hit(const GameObject& other) {
    kill();
}

void Alien::flipTarget() {
    isTarget = !isTarget;
}

void Alien::draw() const {
    if (isTarget) {
        ofSetColor(255, 0, 0);
        ofDrawRectangle(getBounds());
    }
    AbstractGameObject::draw();
}
