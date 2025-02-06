#include "ofApp.h"
#include <iostream>
//--------------------------------------------------------------
void ofApp::setup(){
    ship.setup();
    shot = nullptr;
}

//--------------------------------------------------------------
void ofApp::update(){
    float s = ofGetLastFrameTime();
    Shoot* temp = ship.update(s);
    if (temp) shot = temp;
    
    if (shot) {
        shot->update(s);
        
        if (shot->getY() < 0) {
            delete shot;
            shot = nullptr;
            ship.enableShoot();
        }
    }
}

//--------------------------------------------------------------
void ofApp::draw(){
    ship.draw();
    
    if (shot) {
        cout << shot->getY() << endl;
        shot->draw();
    }
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
