#include "Shot.hpp"

Shot::Shot()
: AbstractGameObject("image/intruderShot.png")
{
}

void Shot::update(float s)
{
    this->y += - 500.0f * s;
}

bool Shot::finished() {
    return y < 0;
}
