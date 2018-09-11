package com.factionsimulator.fs.ui.components;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.MenuBar;

public class MainMenu extends MenuBar {

	private static final long serialVersionUID = 2696796810135733442L;

	private MenuItem characterItems;
	private MenuItem homeView;

	private Navigator navigator;

	private Command menucommand;
	
    private Map<String, String> viewNames = new HashMap<String, String>();
    
	public MainMenu(Navigator navigator) {
		this.navigator = navigator;
        setHeight("53px");
		init();
	}
	
	private void init() {
		menucommand = new Command() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = -2690240719318728853L;

			public void menuSelected(MenuItem selectedItem) {

				navigator.navigateTo(viewNames.get(selectedItem.getText()));
		    }
		};
		this.setWidth("100%");
	}
	
	public void buildMenu() {

		setHomeView(this.addItem("Home", null));
		setCharacterItems(this.addItem("Character", null));
		
	}
	
	public void addView(MenuItem menuItem, View view, final String vaieName, String caption, Resource icon) {
		menuItem.addItem(caption, icon, menucommand);
		navigator.addView(vaieName, view);
		viewNames.put(caption, vaieName);
	}

	public MenuItem getCharacterItems() {
		return characterItems;
	}

	public void setCharacterItems(MenuItem characterItems) {
		this.characterItems = characterItems;
	}

	public MenuItem getHomeView() {
		return homeView;
	}

	public void setHomeView(MenuItem homeView) {
		this.homeView = homeView;
	}
}
