#ifndef GameManager_hpp
#define GameManager_hpp

#include <vector>

#include "GameObject.hpp"

#define MANAGER GameManager::getInstance()

class GameManager {
    private:
        std::vector<GameObject*> objects;
        std::vector<GameObject*> deleted;
    
        GameManager();
    
        GameManager(const GameManager&) = delete;
        GameManager& operator = (const GameManager&) = delete;
    public:
        static GameManager& getInstance();
        void add(GameObject* object);
        void setup();
        void update();
        void draw() const;
        const std::vector<GameObject*>& getObjects() const;
};



#endif /* GameManager_hpp */
