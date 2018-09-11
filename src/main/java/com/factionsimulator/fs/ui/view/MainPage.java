package com.factionsimulator.fs.ui.view;

import com.factionsimulator.fs.ui.components.MainMenu;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MainPage extends VerticalLayout{

	private static final long serialVersionUID = 9056920777362155299L;
	MenuBar menuBar;
	Panel mainView;
	
	public MainPage() {
		this.setSizeFull();
		CssLayout viewContainer = new CssLayout();
		viewContainer.addStyleName("valo-content");
		viewContainer.setSizeFull();
		viewContainer.setId("view Container");
		
		final Navigator navigator = new Navigator(UI.getCurrent(),viewContainer);

		navigator.setErrorView(ErrorView.class);
		MainMenu mainMenu = new MainMenu(navigator);
		mainMenu.setId("mainMenu");
		initMainMenu(mainMenu);
		this.addComponents(mainMenu,viewContainer);
		this.setExpandRatio(viewContainer, 1);
	}
	
	private void initMainMenu(MainMenu mainMenu) {
		mainMenu.buildMenu();
		
		addViews(mainMenu);
	}
	
	private void addViews(MainMenu mainMenu) {
		MenuItem menuItem = mainMenu.getCharacterItems();
		MenuItem homeItem = mainMenu.getHomeView();
		
		mainMenu.addView(homeItem, new HomeView(), "Home", "Home", null);
		mainMenu.addView(menuItem, new CharacterView(), "Character", "Character", null);
	}
}
