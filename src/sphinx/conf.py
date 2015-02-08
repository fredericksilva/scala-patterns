import sys
import os
import sphinx_rtd_theme

sys.path.insert(0, os.path.abspath('_ext'))

extensions = ['sphinx.ext.todo', 'includecode']
source_suffix = '.rst'
source_encoding = 'utf-8-sig'
master_doc = 'index'
project = u'Scala patterns'
copyright = u'2015 xebia.com'
version = '0.1'
release = '0.1'
exclude_patterns = []
highlight_language = 'scala'
html_theme = 'sphinx_rtd_theme'
html_theme_path = [sphinx_rtd_theme.get_html_theme_path()]
html_title = 'Scala patterns'
html_static_path = []
html_use_smartypants = True
html_add_permalinks = None
todo_include_todos = True
html_copy_source = False
