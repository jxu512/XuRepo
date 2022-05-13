ng new calculator
cd calculator
# new component
ng g c foodcourt
# new service for http etc: config.service.ts
ng g s config
nd serve -o     # This build server locally and bring up browser http://localhost:4200
# Update src/app/app.component.html with app content
ng build hello-angular --base-href=/calculator/   # This build into dist folder, copy to nginx at /usr/share/nginx/html/
Access: http://xulinux/calculator/
