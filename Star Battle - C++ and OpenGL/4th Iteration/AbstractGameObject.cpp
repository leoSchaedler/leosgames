#include "AbstractGameObject.hpp"

AbstractGameObject::AbstractGameObject(const string& spriteName)
    : spriteName(spriteName), alive(true)
{
}

void AbstractGameObject::setup(ofVec2f pos) {
    this->pos = pos;
    
    sprite.load(spriteName);
    sprite.setAnchorPercent(0.5f, 0.5f);
}

void AbstractGameObject::update(float s) {
}

void AbstractGameObject::draw() const {
    ofSetColor(255, 255, 255, 255);
    sprite.draw(pos);
}

ofVec2f AbstractGameObject::getPos() const {
    return pos;
}

ofRectangle AbstractGameObject::getBounds() const {
    float hw = sprite.getWidth() / 2;
    float hh = sprite.getHeight() / 2;
    ofRectangle bounds(pos.x - hw, pos.y - hh, sprite.getWidth(), sprite.getHeight());
    return bounds;
}

void AbstractGameObject::hit(const GameObject& other)
{    
}

AbstractGameObject::~AbstractGameObject() {
}

void AbstractGameObject::kill() {
    alive = false;
}

bool AbstractGameObject::finished() const {
    return !alive;
}
