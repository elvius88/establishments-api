FROM core.harbor.work.py.igrupobbva/runes/base-api:0.1.0

LABEL "py.com.jaha.api.establishments-api.version"=1.0.0

RUN mkdir -p /usr/local/establishments-api
ADD establishments-api-1.0.0.jar /usr/local/establishments-api/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
