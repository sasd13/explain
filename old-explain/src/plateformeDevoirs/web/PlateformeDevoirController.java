package plateformeDevoirs.web;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
//import java.servlet.ServletConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Service.IServicePlateForme;

@SuppressWarnings("serial")
public class PlateformeDevoirController extends HttpServlet {

	@SuppressWarnings("serial")      //("unused")
	private final String URL_FEUILLESDEVOIRS = "urlListDevoirs";
	private final String URL_CONTACTCORRECTEUR = "urlContactCorrecteur";
	private final String URL_ENTETE = "urlIndex";
	private final String URL_MESCOURS = "urlMesCours";			//à declarer dans file confi
	//le fichier de configuration Spring
	private final String[] listUrl={ "urlContactCorrecteur", "urlListDevoirs","urlMesCours",
									"urlIndex"};
	// les paramètres de configuration de l'application trouvés dans [web.xml]
	private final String[] parametres = {URL_FEUILLESDEVOIRS,URL_CONTACTCORRECTEUR,
										URL_ENTETE, URL_MESCOURS};
	private final Map<String, String> params = new HashMap<String, String>();
	
	//les actions
	private final String ACTION_LISTE="listDevoirs";
	private final String ACTION_ENTETE = "";
	private final String ACTION_CONTACTCORRECTEUR = "contactCorrecteur";
	private final String ACTION_MESCOURS = "mesCours";
	// les noms des liens
	private final String lienListDevoirs = "Liste de devoirs";
	private final String lienListCours ="Liste de cours";
	private final String lienContactCorrecteur = "contactCorrecteur";
	private final String lienMesCours ="Mes cours";
	
	
	private Map<String,String> hActionListDevoirs = new HashMap<String, String>(2);	
	private Map<String,String> hEntete = new HashMap<String, String>(2);
	private Map<String,String> hListCours = new HashMap<String, String>(2);
	private Map<String,String> hContactCorrecteur = new HashMap<String, String>(2);

	//parametres d'instance
	
	//DAOs
	
	private IServicePlateForme service = null;
	private IFeuilleDevoirDao feuilleDevoirDao;
	
	public void init() throws ServletException
	{
		//recuperer la configuration de l'application
		ServletConfig config = getServletConfig();
		// traiter les parametres de configuration
		String val = null;
		for (int i = 0; i< parametres.length; i++){
			val  = config.getInitParameter(parametres[i]);
			if (val != null){
				//memoriser la valeur du param
				params.put(parametres[i], val);
			}
		}
	}

	
	public void allerPageIndex(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException
		{
			
			getServletContext().getRequestDispatcher((String) 
					params.get("urlIndex")).forward(request, reponse);
			
			return;
		}
	
	public void allerPageListDevoir(HttpServletRequest request, HttpServletResponse reponse)
		throws ServletException, IOException
	{
		
		getServletContext().getRequestDispatcher((String) 
				params.get("urlListDevoirs")).forward(request, reponse);
		
		return;
	}
	
	
	public void allerContactCorrecteur(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException
		{
			
			getServletContext().getRequestDispatcher((String) 
					params.get("urlContactCorrecteur, reponse")).forward(request, reponse);
			
			return;
		}
	public void allerPageCours(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException
		{
			
			getServletContext().getRequestDispatcher((String) 
					params.get("urlMesCours")).forward(request, reponse);
			
			return;
		}
	
}
