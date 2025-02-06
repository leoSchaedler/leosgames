#include "Ship.hpp"

void Ship::setup()
{
    x = 500;
    y = 730;
    sprite.load("image/intruder.png");
    sprite.setAnchorPercent(0.5f, 0.5f);
    canShoot = true;
}

Shoot* Ship::update(float s)
{
    float speed = 0;
    if (x >= 100 && ofGetKeyPressed(OF_KEY_LEFT)) {
        speed = -300;
    } else if (x < 900 && ofGetKeyPressed(OF_KEY_RIGHT)) {
        speed = 300;
    }
    if (canShoot && ofGetKeyPressed(' ')) {
        Shoot* shot = new Shoot();
        shot->setup(x, y);
        canShoot = false;
        return shot;
    }
    x += speed * s;
    return nullptr;
}

void Ship::draw()
{
    sprite.draw(x, y);
}

void Ship::enableShoot() {
    canShoot = true;
}
