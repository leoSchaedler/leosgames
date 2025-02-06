#include "Shot.hpp"
#include "Alien.hpp"

Shot::Shot()
: AbstractGameObject("image/intruderShot.png")
{
}

void Shot::update(float s)
{
    this->y += - 500.0f * s;
    if (y < 0) {
        kill();
    }
}

void Shot::hit(const GameObject& other) {
    const Alien* alien = dynamic_cast<const Alien*>(&other);
    if (alien) {
        kill();
    }
 }
