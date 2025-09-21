.PHONY: qa

qa:
	./gradlew clean qa

test-firefox:
	./gradlew clean -Pbrowser=firefox qa

test-chrome:
	./gradlew clean -Pbrowser=chrome -Psuite1 qa

test-safari:
	./gradlew clean -Pbrowser=safari -Psuite1 qa

smoky:
	./gradlew clean qa -Psuite1

quick:
	./gradlew clean qa -Psuite2
