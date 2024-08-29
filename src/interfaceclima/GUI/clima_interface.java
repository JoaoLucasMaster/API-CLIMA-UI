
package interfaceclima.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class clima_interface extends javax.swing.JFrame {

     ImageIcon iconeChuvoso;
    ImageIcon iconeFrio;
    ImageIcon iconeSol;
    ImageIcon iconeNublado;
    HashMap<Object, Object> mapaClima = new HashMap<>();
    
    public clima_interface() {
        
        setTitle("Aplicação de Clima");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        
    
     // Inicializando o Mapa de Siglas e Descrições
        inicializarMapaClima();
        
        btnBuscaCidade.setBounds(230, 50, 120, 25);
        
        //resultadoTextArea.setBounds(20, 90, 340, 150);
        resultadoTextArea.setEditable(false);
        
       // iconeLabel.setBounds(200, 200, 200, 200); // Tamanho para os ícones

     
        
         // Ação do botão
        btnBuscaCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cidade = cidadeTextField.getText();
                buscarClima(cidade);
            }
        });
          carregarIcones(); // Carregar os ícones durante a inicialização
}
    
       public void carregarIcones() {
        iconeChuvoso = new ImageIcon(getClass().getResource("/interfaceclima/GUI/iconeChuvoso.png"));
        iconeFrio = new ImageIcon(getClass().getResource("/interfaceclima/GUI/iconeFrio.png"));
        iconeSol = new ImageIcon(getClass().getResource("/interfaceclima/GUI/iconeSol.png"));
        iconeNublado = new ImageIcon(getClass().getResource("/interfaceclima/GUI/iconeNublado.png"));
    }
       
       public ImageIcon obterIconeClima(String siglaClima) {
        switch (siglaClima) {
            case "ec": // Encoberto com Chuvas Isoladas
            case "ci": // Chuvas Isoladas
            case "c":  // Chuva
            case "pp": // Poss. de Pancadas de Chuva
            case "ch": // Chuvoso
            case "cm": // Chuva pela Manhã
            case "cn": // Chuva a Noite
            case "pt": // Pancadas de Chuva a Tarde
            case "pm": // Pancadas de Chuva pela Manhã
            case "np": // Nublado e Pancadas de Chuva
            case "pc": // Pancadas de Chuva
            case "pnt": // Pancadas de Chuva a Noite
            case "psc": // Possibilidade de Chuva
            case "pcm": // Possibilidade de Chuva pela Manhã
            case "pct": // Possibilidade de Chuva a Tarde
            case "pcn": // Possibilidade de Chuva a Noite
            case "npt": // Nublado com Pancadas a Tarde
            case "npn": // Nublado com Pancadas a Noite
            case "npp": // Nublado com Possibilidade de Chuva
            case "ncm": // Nublado com Possibilidade de Chuva pela Manhã
                return iconeChuvoso;

            case "cl": // Céu Claro
            case "ps": // Predomínio de Sol
                return iconeSol;

            case "n":  // Nublado
            case "e":  // Encoberto
            case "in": // Instável
            case "vn": // Variação de Nebulosidade
            case "pn": // Parcialmente Nublado
            return iconeNublado;

            case "g":  // Geada
            case "ne": // Neve
            case "nv": // Nevoeiro
            case "ct": // Chuva a Tarde
            case "ppn": // Poss. de Pancadas de Chuva a Noite
            case "ppt": // Poss. de Pancadas de Chuva a Tarde
            case "ppm": // Poss. de Pancadas de Chuva pela Manhã
            case "nct": // Nublado com Poss. de Chuva a Tarde
            case "ncn": // Nublado com Poss. de Chuva a Noite
                return iconeFrio;

            default:
                return null;
        }
    }
    
    public void inicializarMapaClima() {
        
        mapaClima.put("ec", "Encoberto com Chuvas Isoladas");
        mapaClima.put("ci", "Chuvas Isoladas");
        mapaClima.put("c", "Chuva");
        mapaClima.put("in", "Instável");
        mapaClima.put("pp", "Poss. de Pancadas de Chuva");
        mapaClima.put("cm", "Chuva pela Manhã");
        mapaClima.put("cn", "Chuva a Noite");
        mapaClima.put("pt", "Pancadas de Chuva a Tarde");
        mapaClima.put("pm", "Pancadas de Chuva pela Manhã");
        mapaClima.put("np", "Nublado e Pancadas de Chuva");
        mapaClima.put("pc", "Pancadas de Chuva");
        mapaClima.put("pn", "Parcialmente Nublado");
        mapaClima.put("cv", "Chuvisco");
        mapaClima.put("ch", "Chuvoso");
        mapaClima.put("t", "Tempestade");
        mapaClima.put("ps", "Predomínio de Sol");
        mapaClima.put("e", "Encoberto");
        mapaClima.put("n", "Nublado");
        mapaClima.put("cl", "Céu Claro");
        mapaClima.put("nv", "Nevoeiro");
        mapaClima.put("g", "Geada");
        mapaClima.put("ne", "Neve");
        mapaClima.put("nd", "Não Definido");
        mapaClima.put("pnt", "Pancadas de Chuva a Noite");
        mapaClima.put("psc", "Possibilidade de Chuva");
        mapaClima.put("pcm", "Possibilidade de Chuva pela Manhã");
        mapaClima.put("pct", "Possibilidade de Chuva a Tarde");
        mapaClima.put("pcn", "Possibilidade de Chuva a Noite");
        mapaClima.put("npt", "Nublado com Pancadas a Tarde");
        mapaClima.put("npn", "Nublado com Pancadas a Noite");
        mapaClima.put("ncn", "Nublado com Poss. de Chuva a Noite");
        mapaClima.put("nct", "Nublado com Poss. de Chuva a Tarde");
        mapaClima.put("ncm", "Nublado c/ Poss. de Chuva pela Manhã");
        mapaClima.put("npm", "Nublado com Pancadas pela Manhã");
        mapaClima.put("npp", "Nublado com Possibilidade de Chuva");
        mapaClima.put("vn", "Variação de Nebulosidade");
        mapaClima.put("ct", "Chuva a Tarde");
        mapaClima.put("ppn", "Poss. de Pancadas de Chuva a Noite");
        mapaClima.put("ppt", "Poss. de Pancadas de Chuva a Tarde");
        mapaClima.put("ppm", "Poss. de Pancadas de Chuva pela Manhã");
    }

    
    public String buscarCodigoCidade(String cidade) {
        String codigoCidade = "";
        try {
            String urlCidade = "http://servicos.cptec.inpe.br/XML/listaCidades?city=" + cidade.replace(" ", "%20");
            URL url = new URL(urlCidade);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Parse do XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(conn.getInputStream());

            NodeList nList = doc.getElementsByTagName("cidade");

            if (nList.getLength() > 0) {
                Node node = nList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    codigoCidade = element.getElementsByTagName("id").item(0).getTextContent();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigoCidade;
    }
    
    public void buscarClima(String cidade) {
        String codigoCidade = buscarCodigoCidade(cidade);
        if (codigoCidade.isEmpty()) {
            resultadoTextArea.setText("Cidade não encontrada!");
            return;
        }

        try {
            String urlClima = "http://servicos.cptec.inpe.br/XML/cidade/" + codigoCidade + "/previsao.xml";
            URL url = new URL(urlClima);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Parse do XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(conn.getInputStream());

            NodeList nList = doc.getElementsByTagName("previsao");

            if (nList.getLength() > 0) {
                Node node = nList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String dia = element.getElementsByTagName("dia").item(0).getTextContent();
                    String tempo = element.getElementsByTagName("tempo").item(0).getTextContent();
                    String maxima = element.getElementsByTagName("maxima").item(0).getTextContent();
                    String minima = element.getElementsByTagName("minima").item(0).getTextContent();
                    String iuv = element.getElementsByTagName("iuv").item(0).getTextContent();

                    String descricaoClima = (String) mapaClima.getOrDefault(tempo, "Não Definido");

                    resultadoTextArea.setText("Previsão para: " + dia + "\n" +
                            "Clima: " + descricaoClima + "\n" +
                            "Temperatura Máxima: " + maxima + "°C\n" +
                            "Temperatura Mínima: " + minima + "°C\n" +
                            "Índice UV: " + iuv);

                    ImageIcon iconeClima = obterIconeClima(tempo);
                    if (iconeClima != null) {
                        iconeLabel.setIcon(iconeClima);
                    } else {
                        iconeLabel.setIcon(null);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jComboBox1 = new javax.swing.JComboBox<>();
        cidadeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoTextArea = new javax.swing.JTextArea();
        btnBuscaCidade = new javax.swing.JButton();
        iconeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cidadeTextField.setBackground(new java.awt.Color(255, 255, 255));
        cidadeTextField.setForeground(new java.awt.Color(0, 0, 0));
        cidadeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("DIGITE O NOME DA CIDADE PARA ANALISE:");

        resultadoTextArea.setColumns(20);
        resultadoTextArea.setRows(5);
        jScrollPane1.setViewportView(resultadoTextArea);

        btnBuscaCidade.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscaCidade.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscaCidade.setText("ANALISAR");
        btnBuscaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCidadeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceclima/GUI/cptec.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceclima/GUI/logoif.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceclima/GUI/mascotejava.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(iconeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscaCidade)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.getAccessibleContext().setAccessibleName("logoif");
        jLabel3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cidadeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeTextFieldActionPerformed
      
        
              
    }//GEN-LAST:event_cidadeTextFieldActionPerformed

    private void btnBuscaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaCidadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clima_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clima_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clima_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clima_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clima_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaCidade;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JLabel iconeLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadoTextArea;
    // End of variables declaration//GEN-END:variables
}
