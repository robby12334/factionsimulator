package com.factionsimulator.fs.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;

public class CharacterView extends CssLayout implements View{

	private static final long serialVersionUID = -5650770189806584640L;

	private Button testButton;
	private VerticalLayout vertLayout;
	
	public CharacterView() {
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		setSizeFull();
		testButton = new Button("Test Button");
		
		vertLayout = new VerticalLayout();
		vertLayout.addComponent(testButton);
		vertLayout.setSizeFull();
		vertLayout.setExpandRatio(testButton, 1);
		addComponent(vertLayout);
	}

}
