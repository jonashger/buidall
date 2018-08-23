package io.github.jonashger.buildall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	private String folderDestino = "D:\\builds";
	private static JButton btnAdicionar = new JButton("Adicionar Projeto");
	private static JButton btnGerarBuild = new JButton("Gerar Build");
	private static JButton btnConfigurar = new JButton("Configurar");
	private static JButton btnPastaDestino = new JButton("Pasta Destino");
	private static String[] listItens;
	JButton go;

	static JFileChooser chooser;
	static String choosertitle;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abrir();

	}

	public static void abrir() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 289);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 233);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		if (listItens == null) {

		}

		AbstractListModel abstractListModel = new AbstractListModel() {
			String[] values = new String[] { "um", "dois" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		};
		abstractListModel.getListDataListeners();

		JList<String> list = new JList<>();
		list.setModel(abstractListModel);
		list.setBounds(10, 11, 544, 179);
		panel.add(list);

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarLista();

			}

		});
		btnAdicionar.setBounds(10, 201, 171, 23);
		panel.add(btnAdicionar);

		btnGerarBuild.setBounds(465, 201, 89, 23);
		panel.add(btnGerarBuild);

		btnConfigurar.setBounds(366, 201, 89, 23);
		panel.add(btnConfigurar);

		btnPastaDestino.setBounds(202, 201, 115, 23);
		panel.add(btnPastaDestino);

	}

	private static void adicionarLista() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}
	}

}
