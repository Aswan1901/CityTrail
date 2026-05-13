FROM gradle:8-jdk21
WORKDIR /app

# Cache dependencies first
COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon

COPY src ./src

CMD ["gradle", "bootRun", "--no-daemon"]