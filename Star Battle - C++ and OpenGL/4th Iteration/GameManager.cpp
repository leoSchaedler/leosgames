#include "GameManager.hpp"
#include "ofMain.h"

using namespace std;

GameManager::GameManager() {
}

GameManager& GameManager::getInstance() {
    static GameManager instance;
    return instance;
}

void GameManager::add(GameObject* object) {
    objects.push_back(object);
}

void GameManager::setup() {
}

void GameManager::update() {
    auto temp = objects;
    for (GameObject* obj : temp) {
        obj->update(ofGetLastFrameTime());
    }
    
    for (GameObject* obj : deleted) {
        delete obj;
    }
    deleted.clear();
    
    for (int i = 0; i < objects.size()-1; i++) {
        for (int j = i+1; j < objects.size(); j++) {
            GameObject* obj1 = objects[i];
            GameObject* obj2 = objects[j];
            
            //Um objeto colidiu com outro?
            if (obj1->getBounds().intersects(obj2->getBounds())) {
                obj1->hit(*obj2);
                obj2->hit(*obj1);
            }
        }
    }
    
    vector<GameObject*> alive;
    for (GameObject* obj : objects) {
        if (obj->finished()) {
            deleted.push_back(obj);
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

const std::vector<GameObject*>& GameManager::getObjects() const {
    return objects;
}
