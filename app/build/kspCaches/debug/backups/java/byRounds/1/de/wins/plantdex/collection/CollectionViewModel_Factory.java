package de.wins.plantdex.collection;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import de.wins.plantdex.core.data.PlantRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class CollectionViewModel_Factory implements Factory<CollectionViewModel> {
  private final Provider<PlantRepository> plantRepositoryProvider;

  public CollectionViewModel_Factory(Provider<PlantRepository> plantRepositoryProvider) {
    this.plantRepositoryProvider = plantRepositoryProvider;
  }

  @Override
  public CollectionViewModel get() {
    return newInstance(plantRepositoryProvider.get());
  }

  public static CollectionViewModel_Factory create(
      Provider<PlantRepository> plantRepositoryProvider) {
    return new CollectionViewModel_Factory(plantRepositoryProvider);
  }

  public static CollectionViewModel newInstance(PlantRepository plantRepository) {
    return new CollectionViewModel(plantRepository);
  }
}
