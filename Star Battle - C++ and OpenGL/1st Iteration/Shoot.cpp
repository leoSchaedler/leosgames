#include "Shoot.hpp"

void Shoot::setup(float x, float y)
{
    this->x = x;
    this->y = y;
    
    sprite.load("image/intruderShot.png");
    sprite.setAnchorPercent(0.5f, 0.5f);
}

void Shoot::update(float s)
{
    this->y += - 500.0f * s;
}

void Shoot::draw()
{
    sprite.draw(x, y);
}

float Shoot::getY() {
    return y;
}
