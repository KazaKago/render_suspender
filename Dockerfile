FROM eclipse-temurin:21-alpine

ENV APP_HOME /app

WORKDIR $APP_HOME
COPY ./ $APP_HOME/
RUN ./gradlew installDist

CMD ["build/install/render_suspender/bin/render_suspender"]
