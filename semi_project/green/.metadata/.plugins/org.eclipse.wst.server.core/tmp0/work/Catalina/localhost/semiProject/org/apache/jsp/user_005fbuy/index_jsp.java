/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-23 13:03:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user_005fbuy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!doctype html>\r\n");

	String pages = "";
	if(request.getParameter("pages")!=null){
		pages = request.getParameter("pages");		
	} else{
		pages = "buy_body";
	}

      out.write("\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <title>document</title>\r\n");
      out.write("    <!-- 부트스트랩 CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\r\n");
      out.write("    <!-- Simple bar CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/simplebar.css\">\r\n");
      out.write("    <!-- Fonts CSS -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Icons CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/feather.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/select2.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/dropzone.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/uppy.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery.steps.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery.timepicker.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/quill.snow.css\">\r\n");
      out.write("    <!-- Date Range Picker CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/daterangepicker.css\">\r\n");
      out.write("    <!-- App CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/app-light.css\" id=\"lightTheme\" >\r\n");
      out.write("  </head>\r\n");
      out.write("  <body class=\"vertical  dark  \">\r\n");
      out.write("    <div class=\"wrapper\">\r\n");
      out.write("    	<nav class=\"topnav navbar navbar-light\">\r\n");
      out.write("	        <button type=\"button\" class=\"navbar-toggler text-muted mt-2 p-0 mr-3 collapseSidebar\">\r\n");
      out.write("	          <i class=\"fe fe-menu navbar-toggler-icon\"></i>\r\n");
      out.write("	        </button>\r\n");
      out.write("	        <ul class=\"nav\">\r\n");
      out.write("	          <li class=\"nav-item dropdown\">\r\n");
      out.write("	            <a class=\"nav-link dropdown-toggle text-muted pr-0\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("	              <span class=\"avatar avatar-sm mt-2\">\r\n");
      out.write("	                <img src=\"./assets/avatars/face-1.jpg\" alt=\"...\" class=\"avatar-img rounded-circle\">\r\n");
      out.write("	              </span>\r\n");
      out.write("	            </a>\r\n");
      out.write("	            <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("	              <a class=\"dropdown-item\" href=\"#\">Profile</a>\r\n");
      out.write("	              <a class=\"dropdown-item\" href=\"#\">Settings</a>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </li>\r\n");
      out.write("	        </ul>\r\n");
      out.write("	      </nav>\r\n");
      out.write("	      <aside class=\"sidebar-left border-right bg-white shadow\" id=\"leftSidebar\" data-simplebar>\r\n");
      out.write("        	<a href=\"#\" class=\"btn collapseSidebar toggle-btn d-lg-none text-muted ml-2 mt-3\" data-toggle=\"toggle\">\r\n");
      out.write("         	    <i class=\"fe fe-x\"><span class=\"sr-only\"></span></i>\r\n");
      out.write("        	</a>\r\n");
      out.write("        	<nav class=\"vertnav navbar navbar-light\">\r\n");
      out.write("          <!-- nav bar -->\r\n");
      out.write("          <div class=\"w-100 mb-4 d-flex\">\r\n");
      out.write("            <a class=\"navbar-brand mx-auto mt-2 flex-fill text-center\" href=\"user_index.jsp\">\r\n");
      out.write("              <svg version=\"1.1\" id=\"logo\" class=\"navbar-brand-img brand-sm\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" viewBox=\"0 0 120 120\" xml:space=\"preserve\">\r\n");
      out.write("                <g>\r\n");
      out.write("                  <polygon class=\"st0\" points=\"78,105 15,105 24,87 87,87 	\" />\r\n");
      out.write("                  <polygon class=\"st0\" points=\"96,69 33,69 42,51 105,51 	\" />\r\n");
      out.write("                  <polygon class=\"st0\" points=\"78,33 15,33 24,15 87,15 	\" />\r\n");
      out.write("                </g>\r\n");
      out.write("              </svg>\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("           <!-- 좌측 네비게이션 바 -->\r\n");
      out.write("          <p class=\"text-muted nav-heading mt-4 mb-1\">\r\n");
      out.write("          </p>\r\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "user_nav.jsp", out, false);
      out.write("\r\n");
      out.write("          </aside>\r\n");
      out.write("      <main role=\"main\" class=\"main-content\">\r\n");
      out.write("     	 ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  pages+".jsp", out, false);
      out.write("\r\n");
      out.write("      </main>\r\n");
      out.write("    </div> <!-- .wrapper -->\r\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"js/moment.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"js/simplebar.min.js\"></script>\r\n");
      out.write("    <script src='js/daterangepicker.js'></script>\r\n");
      out.write("    <script src='js/jquery.stickOnScroll.js'></script>\r\n");
      out.write("    <script src=\"js/tinycolor-min.js\"></script>\r\n");
      out.write("    <script src=\"js/config.js\"></script>\r\n");
      out.write("    <script src=\"js/d3.min.js\"></script>\r\n");
      out.write("    <script src=\"js/topojson.min.js\"></script>\r\n");
      out.write("    <script src=\"js/datamaps.all.min.js\"></script>\r\n");
      out.write("    <script src=\"js/datamaps-zoomto.js\"></script>\r\n");
      out.write("    <script src=\"js/datamaps.custom.js\"></script>\r\n");
      out.write("    <script src=\"js/Chart.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      /* defind global options */\r\n");
      out.write("      Chart.defaults.global.defaultFontFamily = base.defaultFontFamily;\r\n");
      out.write("      Chart.defaults.global.defaultFontColor = colors.mutedColor;\r\n");
      out.write("    </script>\r\n");
      out.write("    <script src=\"js/gauge.min.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.sparkline.min.js\"></script>\r\n");
      out.write("    <script src=\"js/apexcharts.min.js\"></script>\r\n");
      out.write("    <script src=\"js/apexcharts.custom.js\"></script>\r\n");
      out.write("    <script src='js/jquery.mask.min.js'></script>\r\n");
      out.write("    <script src='js/select2.min.js'></script>\r\n");
      out.write("    <script src='js/jquery.steps.min.js'></script>\r\n");
      out.write("    <script src='js/jquery.validate.min.js'></script>\r\n");
      out.write("    <script src='js/jquery.timepicker.js'></script>\r\n");
      out.write("    <script src='js/dropzone.min.js'></script>\r\n");
      out.write("    <script src='js/uppy.min.js'></script>\r\n");
      out.write("    <script src='js/quill.min.js'></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      $('.select2').select2(\r\n");
      out.write("      {\r\n");
      out.write("        theme: 'bootstrap4',\r\n");
      out.write("      });\r\n");
      out.write("      $('.select2-multi').select2(\r\n");
      out.write("      {\r\n");
      out.write("        multiple: true,\r\n");
      out.write("        theme: 'bootstrap4',\r\n");
      out.write("      });\r\n");
      out.write("      $('.drgpicker').daterangepicker(\r\n");
      out.write("      {\r\n");
      out.write("        singleDatePicker: true,\r\n");
      out.write("        timePicker: false,\r\n");
      out.write("        showDropdowns: true,\r\n");
      out.write("        locale:\r\n");
      out.write("        {\r\n");
      out.write("          format: 'MM/DD/YYYY'\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("      $('.time-input').timepicker(\r\n");
      out.write("      {\r\n");
      out.write("        'scrollDefault': 'now',\r\n");
      out.write("        'zindex': '9999' /* fix modal open */\r\n");
      out.write("      });\r\n");
      out.write("      /** date range picker */\r\n");
      out.write("      if ($('.datetimes').length)\r\n");
      out.write("      {\r\n");
      out.write("        $('.datetimes').daterangepicker(\r\n");
      out.write("        {\r\n");
      out.write("          timePicker: true,\r\n");
      out.write("          startDate: moment().startOf('hour'),\r\n");
      out.write("          endDate: moment().startOf('hour').add(32, 'hour'),\r\n");
      out.write("          locale:\r\n");
      out.write("          {\r\n");
      out.write("            format: 'M/DD hh:mm A'\r\n");
      out.write("          }\r\n");
      out.write("        });\r\n");
      out.write("      }\r\n");
      out.write("      var start = moment().subtract(29, 'days');\r\n");
      out.write("      var end = moment();\r\n");
      out.write("\r\n");
      out.write("      function cb(start, end)\r\n");
      out.write("      {\r\n");
      out.write("        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));\r\n");
      out.write("      }\r\n");
      out.write("      $('#reportrange').daterangepicker(\r\n");
      out.write("      {\r\n");
      out.write("        startDate: start,\r\n");
      out.write("        endDate: end,\r\n");
      out.write("        ranges:\r\n");
      out.write("        {\r\n");
      out.write("          'Today': [moment(), moment()],\r\n");
      out.write("          'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],\r\n");
      out.write("          'Last 7 Days': [moment().subtract(6, 'days'), moment()],\r\n");
      out.write("          'Last 30 Days': [moment().subtract(29, 'days'), moment()],\r\n");
      out.write("          'This Month': [moment().startOf('month'), moment().endOf('month')],\r\n");
      out.write("          'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]\r\n");
      out.write("        }\r\n");
      out.write("      }, cb);\r\n");
      out.write("      cb(start, end);\r\n");
      out.write("      $('.input-placeholder').mask(\"00/00/0000\",\r\n");
      out.write("      {\r\n");
      out.write("        placeholder: \"__/__/____\"\r\n");
      out.write("      });\r\n");
      out.write("      $('.input-zip').mask('00000-000',\r\n");
      out.write("      {\r\n");
      out.write("        placeholder: \"____-___\"\r\n");
      out.write("      });\r\n");
      out.write("      $('.input-money').mask(\"#.##0,00\",\r\n");
      out.write("      {\r\n");
      out.write("        reverse: true\r\n");
      out.write("      });\r\n");
      out.write("      $('.input-mixed').mask('AAA 000-S0S');\r\n");
      out.write("      $('.input-ip').mask('0ZZ.0ZZ.0ZZ.0ZZ',\r\n");
      out.write("      {\r\n");
      out.write("        translation:\r\n");
      out.write("        {\r\n");
      out.write("          'Z':\r\n");
      out.write("          {\r\n");
      out.write("            pattern: /[0-9]/,\r\n");
      out.write("            optional: true\r\n");
      out.write("          }\r\n");
      out.write("        },\r\n");
      out.write("        placeholder: \"___.___.___.___\"\r\n");
      out.write("      });\r\n");
      out.write("      // editor\r\n");
      out.write("      var editor = document.getElementById('editor');\r\n");
      out.write("      if (editor)\r\n");
      out.write("      {\r\n");
      out.write("        var toolbarOptions = [\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'font': []\r\n");
      out.write("          }],\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'header': [1, 2, 3, 4, 5, 6, false]\r\n");
      out.write("          }],\r\n");
      out.write("          ['bold', 'italic', 'underline', 'strike'],\r\n");
      out.write("          ['blockquote', 'code-block'],\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'header': 1\r\n");
      out.write("          },\r\n");
      out.write("          {\r\n");
      out.write("            'header': 2\r\n");
      out.write("          }],\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'list': 'ordered'\r\n");
      out.write("          },\r\n");
      out.write("          {\r\n");
      out.write("            'list': 'bullet'\r\n");
      out.write("          }],\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'script': 'sub'\r\n");
      out.write("          },\r\n");
      out.write("          {\r\n");
      out.write("            'script': 'super'\r\n");
      out.write("          }],\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'indent': '-1'\r\n");
      out.write("          },\r\n");
      out.write("          {\r\n");
      out.write("            'indent': '+1'\r\n");
      out.write("          }], // outdent/indent\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'direction': 'rtl'\r\n");
      out.write("          }], // text direction\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'color': []\r\n");
      out.write("          },\r\n");
      out.write("          {\r\n");
      out.write("            'background': []\r\n");
      out.write("          }], // dropdown with defaults from theme\r\n");
      out.write("          [\r\n");
      out.write("          {\r\n");
      out.write("            'align': []\r\n");
      out.write("          }],\r\n");
      out.write("          ['clean'] // remove formatting button\r\n");
      out.write("        ];\r\n");
      out.write("        var quill = new Quill(editor,\r\n");
      out.write("        {\r\n");
      out.write("          modules:\r\n");
      out.write("          {\r\n");
      out.write("            toolbar: toolbarOptions\r\n");
      out.write("          },\r\n");
      out.write("          theme: 'snow'\r\n");
      out.write("        });\r\n");
      out.write("      }\r\n");
      out.write("      // Example starter JavaScript for disabling form submissions if there are invalid fields\r\n");
      out.write("      (function()\r\n");
      out.write("      {\r\n");
      out.write("        'use strict';\r\n");
      out.write("        window.addEventListener('load', function()\r\n");
      out.write("        {\r\n");
      out.write("          // Fetch all the forms we want to apply custom Bootstrap validation styles to\r\n");
      out.write("          var forms = document.getElementsByClassName('needs-validation');\r\n");
      out.write("          // Loop over them and prevent submission\r\n");
      out.write("          var validation = Array.prototype.filter.call(forms, function(form)\r\n");
      out.write("          {\r\n");
      out.write("            form.addEventListener('submit', function(event)\r\n");
      out.write("            {\r\n");
      out.write("              if (form.checkValidity() === false)\r\n");
      out.write("              {\r\n");
      out.write("                event.preventDefault();\r\n");
      out.write("                event.stopPropagation();\r\n");
      out.write("              }\r\n");
      out.write("              form.classList.add('was-validated');\r\n");
      out.write("            }, false);\r\n");
      out.write("          });\r\n");
      out.write("        }, false);\r\n");
      out.write("      })();\r\n");
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("      var uptarg = document.getElementById('drag-drop-area');\r\n");
      out.write("      if (uptarg)\r\n");
      out.write("      {\r\n");
      out.write("        var uppy = Uppy.Core().use(Uppy.Dashboard,\r\n");
      out.write("        {\r\n");
      out.write("          inline: true,\r\n");
      out.write("          target: uptarg,\r\n");
      out.write("          proudlyDisplayPoweredByUppy: false,\r\n");
      out.write("          theme: 'dark',\r\n");
      out.write("          width: 770,\r\n");
      out.write("          height: 210,\r\n");
      out.write("          plugins: ['Webcam']\r\n");
      out.write("        }).use(Uppy.Tus,\r\n");
      out.write("        {\r\n");
      out.write("          endpoint: 'https://master.tus.io/files/'\r\n");
      out.write("        });\r\n");
      out.write("        uppy.on('complete', (result) =>\r\n");
      out.write("        {\r\n");
      out.write("          console.log('Upload complete! We’ve uploaded these files:', result.successful)\r\n");
      out.write("        });\r\n");
      out.write("      }\r\n");
      out.write("    </script>\\\r\n");
      out.write("    <script src=\"js/apps.js\"></script>\r\n");
      out.write("    <!-- Global site tag (gtag.js) - Google Analytics -->\r\n");
      out.write("    <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-56159088-1\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      window.dataLayer = window.dataLayer || [];\r\n");
      out.write("\r\n");
      out.write("      function gtag()\r\n");
      out.write("      {\r\n");
      out.write("        dataLayer.push(arguments);\r\n");
      out.write("      }\r\n");
      out.write("      gtag('js', new Date());\r\n");
      out.write("      gtag('config', 'UA-56159088-1');\r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
