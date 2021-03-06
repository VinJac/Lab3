/*
 * Copyright (c) 2016, Frédéric Fauberteau
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY FRÉDÉRIC FAUBERTEAU AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package controller;

import model.UserList;
import view.CLI;
import view.GUI;
import view.View;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.TimeUnit;

/**
 * @author Frédéric Fauberteau
 */
public class Main2 {

    public static void main(String[] args) {
        UserList model = new UserList();
        GUI gui = new GUI(model, "Lab3", 320, 240);
        CLI cli = new CLI(model);
        Set<View> set = new HashSet<>(Arrays.asList(gui, cli));
        Controller controller = new Controller(model, set);
        controller.start();
        
        model.addUser("triaxx");
        
        // Rk: we don't need to add this, but it works better if we mark a pause between
        // users adding (because the CLI starts a new thread, that will otherwise capture
        // all the added users, three times)
        try {
			TimeUnit.MILLISECONDS.sleep(50);		// waits 50ms, then adds the second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        model.addUser("violine");
        
        try {
        	TimeUnit.MILLISECONDS.sleep(50);		// waits 50ms, then adds the third
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        model.addUser("root");
    }

}