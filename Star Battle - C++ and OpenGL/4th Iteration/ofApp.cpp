#include "ofApp.h"
#include <iostream>

#include "Ship.hpp"
#include "Alien.hpp"
#include "Shot.hpp"

#include "GameManager.hpp"

//--------------------------------------------------------------
void ofApp::setup(){
    Ship* ship = new Ship();
    ship->setup(ofVec2f(500, 730));
    MANAGER.add(ship);
    
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 4; j++) {
            Alien* alien = new Alien();
            alien->setup(ofVec2f(100 + 100 * i, 100 + 75 * j));
            MANAGER.add(alien);
        }
    }
    
    MANAGER.setup();
}

//--------------------------------------------------------------
void ofApp::update(){
    MANAGER.update();
}

//--------------------------------------------------------------
void ofApp::draw(){
    MANAGER.draw();
}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){

}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){

}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mouseEntered(int x, int y){

}

//--------------------------------------------------------------
void ofApp::mouseExited(int x, int y){

}

//--------------------------------------------------------------
void ofApp::windowResized(int w, int h){

}

//--------------------------------------------------------------
void ofApp::gotMessage(ofMessage msg){

}

//--------------------------------------------------------------
void ofApp::dragEvent(ofDragInfo dragInfo){ 

}
