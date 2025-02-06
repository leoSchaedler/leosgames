#include <vector>

#include "Missile.hpp"
#include "Alien.hpp"
#include "GameManager.hpp"

Missile::Missile()
: AbstractGameObject("image/destroyerShot.png")
{
}

void Missile::setup(ofVec2f pos)
{
    AbstractGameObject::setup(pos);
    
    //Separa só os aliens
    std::vector<Alien*> aliens;
    for (auto obj : MANAGER.getObjects()) {
        Alien* alien = dynamic_cast<Alien*>(obj);
        if (alien) aliens.push_back(alien);
    }
    
    //Sorteia um alien
    std::uniform_int_distribution<int> dist(0, aliens.size()-1);
    int idx = dist(mt);
    target = aliens[idx];
    target->flipTarget();
}

void Missile::update(float s)
{
    if (target->finished()) {
        target = nullptr;
    }
    
    if (target) {
        if (this->pos.x < target->getPos().x) {
            this->pos.x += 50.0f * s;
        } else if (this->pos.x > target->getPos().x) {
            this->pos.x -= 50.0f * s;
        }
    }
    
    this->pos.y += - 100.0f * s;
    if (pos.y < 0) {
        kill();
    }
}

void Missile::hit(const GameObject& other) {
    const Alien* alien = dynamic_cast<const Alien*>(&other);
    if (alien) {
        target->flipTarget();
        kill();
    }
 }
