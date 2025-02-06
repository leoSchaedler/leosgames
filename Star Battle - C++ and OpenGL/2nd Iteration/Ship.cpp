#include "Ship.hpp"

Ship::Ship()
: AbstractGameObject("image/intruder.png")
{    
}

void Ship::update(float s)
{
    //Movimentação
    float speed = 0;
    if (x >= 100 && ofGetKeyPressed(OF_KEY_LEFT)) {
        speed = -300;
    } else if (x < 900 && ofGetKeyPressed(OF_KEY_RIGHT)) {
        speed = 300;
    }
    x += speed * s;

    //Tiro
    interval += s;
    if (ofGetKeyPressed(' ') && interval > 0.3) {
        interval = 0;
        Shot* shot = new Shot();
        shot->setup(x, y);
        manager->add(shot);
    }
}
