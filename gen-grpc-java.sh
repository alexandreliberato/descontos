pwd
protoc --java_out=ds2/src/infra \
    --java-grpc_out=ds2/src/infra \
    discount.proto
