#include "GameManager.hpp"
#include "ofMain.h"

using namespace std;

void GameManager::add(GameObject* object) {
    object->setManager(this);
    objects.push_back(object);
}

void GameManager::setup() {
}

void GameManager::update() {
    for (GameObject* obj : objects) {
        obj->update(ofGetLastFrameTime());
    }
    
    vector<GameObject*> alive;
    for (GameObject* obj : objects) {
        if (obj->finished()) {
            delete obj;
        } else {
            alive.push_back(obj);
        }
    }
    swap(alive, objects);
}

void GameManager::draw() const {
    for (const GameObject* obj : objects) {
        obj->draw();
    }
}
