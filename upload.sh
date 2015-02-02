lftp -u $FTP_USER,$FTP_PASSWORD s195.webhostingserver.nl <<EOF
cd public_html
glob -a rm -r *
EOF