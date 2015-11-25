package socadastroevendatambem.swing.frames;



	private PainelLogin contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					MinhaAplicacao.get().setTelaPrincipal(frame);
					frame.setVisible(true);
					frame.showLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Só Cadastro v1.1 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 501);
	}

	public void showLogin() {
		contentPane = new PainelLogin();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		revalidate();
	}
	public void showPrincipal() {
		contentPane =  new TelaAba();
		setContentPane(contentPane);
		revalidate();
	}
}

