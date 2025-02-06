#include "AbstractGameObject.hpp"

AbstractGameObject::AbstractGameObject(const string& spriteName)
    : spriteName(spriteName)
{
}

void AbstractGameObject::setup(float x, float y) {
    this->x = x;
    this->y = y;
    
    sprite.load(spriteName);
    sprite.setAnchorPercent(0.5f, 0.5f);
}

void AbstractGameObject::update(float s) {
}

void AbstractGameObject::draw() const {
    sprite.draw(x, y);
}

AbstractGameObject::~AbstractGameObject() {
}

bool AbstractGameObject::finished() {
    return false;
}

void AbstractGameObject::setManager(GameManager* manager) {
    this->manager = manager;
}

