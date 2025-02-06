#include "GameManager.hpp"
#include "Ship.hpp"

#include "Shot.hpp"
#include "Missile.hpp"

Ship::Ship()
: AbstractGameObject("image/intruder.png")
{    
}

void Ship::update(float s)
{    
    //Movimentação
    float speed = 0;
    if (pos.x >= 100 && ofGetKeyPressed(OF_KEY_LEFT)) {
        speed = -300;
    } else if (pos.x < 900 && ofGetKeyPressed(OF_KEY_RIGHT)) {
        speed = 300;
    }
    pos.x += speed * s;

    //Tiro
    interval += s;
    if (ofGetKeyPressed(' ') && interval > 0.3) {
        interval = 0;
        Shot* shot = new Shot();
        shot->setup(pos);
        MANAGER.add(shot);
    }
    
    missileInterval += s;
    if ((ofGetKeyPressed('m') || ofGetKeyPressed('M')) && missileInterval > 1.0) {
        missileInterval = 0;
        Missile* missile = new Missile();
        missile->setup(pos);
        MANAGER.add(missile);
    }

}
